package com.example.carstore.controllers;

import com.example.carstore.entities.*;
import com.example.carstore.repositories.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    CarPartRepo carPartRepo;
    @Autowired
    CarRepo carRepo;

    @Autowired
    CartItemRepo cartItemRepo;

    @Autowired
    CartRepo cartRepo;
    @Autowired
    CustomerRepo customerRepo;

    @PostMapping("/item/{itemType}/{id}")
    public String addItem(HttpSession session, HttpServletRequest request, @PathVariable String itemType, @PathVariable Long id){

        Customer customer= (Customer) session.getAttribute("customer");

        if (customer==null){
            return "redirect:/auth";
        }

        if (itemType.equals("car")){
            Car car = carRepo.findById(id).get();
            CartItem cartItem = new CartItem();

            cartItem.setCar(car);
            cartItem.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            cartItem.setAmount(cartItem.determineAmount());

            cartItemRepo.save(cartItem);


            Long cartId= customer.getCart().getId();

            Cart cart = cartRepo.findById(cartId).get();
            List<CartItem> items=cart.getItems();

            items.add(cartItem);
            cart.setItems(items);
            cart.setTotAmount(cart.determineTotAmount());

            cartRepo.save(cart);

            customer.setCart(cart);

            customerRepo.save(customer);


            //customerRepo

            session.setAttribute("productType",itemType);
            session.setAttribute("product",car);

        }else if (itemType.equals("carpart")){

            CarPart carPart = carPartRepo.findById(id).get();
            CartItem cartItem = new CartItem();

            cartItem.setCarPart(carPart);
            cartItem.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            cartItem.setAmount(cartItem.determineAmount());

            cartItemRepo.save(cartItem);


            Long cartId= customer.getCart().getId();

            Cart cart = cartRepo.findById(cartId).get();
            List<CartItem> items=cart.getItems();

            items.add(cartItem);
            cart.setItems(items);
            cart.setTotAmount(cart.determineTotAmount());

            cartRepo.save(cart);

            customer.setCart(cart);

            customerRepo.save(customer);

            session.setAttribute("productType",itemType);
            session.setAttribute("product",carPart);
        }


        return "redirect:/";
    }


//    @Transactional
    @GetMapping("/cart")
    public String getCart(HttpSession session){

        Customer customer= (Customer) session.getAttribute("customer");

        if (customer==null){
            return "redirect:/auth";
        }

        Cart cart = customerRepo.findById(customer.getId()).get().getCart();
        session.setAttribute("cart", cart);

        return "cartpage";
    }

    @GetMapping("cart/remove/{itemId}")
    public String removeItem(HttpSession session,@PathVariable Long itemId){

        Cart currentCart= (Cart)session.getAttribute("cart");
        Cart cart = cartRepo.findById(currentCart.getId()).get();

        List<CartItem>items= cart.getItems();

        items.removeIf(item -> item.getId() == itemId);

        cart.setItems(items);
        cart.setTotAmount(cart.determineTotAmount());
        cartRepo.save(cart);

        CartItem item = cartItemRepo.findById(itemId).get();
        cartItemRepo.delete(item);

        return "redirect:/cart";
    }
}
