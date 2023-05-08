package com.example.carstore.services;

import com.example.carstore.entities.*;
import com.example.carstore.repositories.CartRepo;
import com.example.carstore.repositories.CustomerRepo;
import com.example.carstore.repositories.OrderItemRepo;
import com.example.carstore.repositories.OrderRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderServiceInterface{

    @Autowired
    OrderRepo orderRepo;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    OrderItemRepo orderItemRepo;


    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public void placeOrder( Customer currentCustomer) {

       // Customer currentCustomer = (Customer) session.getAttribute("customer");

        Customer customer = customerRepo.findById(currentCustomer.getId()).get();

        Cart cart = customer.getCart();

        List<CartItem>items=cart.getItems();

        Order order= new Order();

        List<OrderItem>orderItems=new ArrayList<>();

        for (CartItem item:items){
            OrderItem orderItem= new OrderItem();
            orderItem.setCartItem(item);
            orderItems.add(orderItem);
        }

        orderItemRepo.saveAll(orderItems);

        order.setCustomer(customer);
        order.setItems(orderItems);
        order.setTotalAmount(cart.getTotAmount());

        Date currentDate = new Date();
        order.setOrderDate(currentDate);

        orderRepo.save(order);

        cart.setItems(null);
        cart.setTotAmount(0.0);

        cartRepo.save(cart);

        customer.setCart(cart);

        customerRepo.save(customer);



    }
}
