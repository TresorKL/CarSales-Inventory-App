package com.example.carstore.controllers;

import com.example.carstore.entities.Customer;
import com.example.carstore.services.OrderServiceInterface;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @Autowired
    OrderServiceInterface orderServiceInterface;

    @GetMapping("/order/successful")
    public String getSuccessfulOrderPage(){
        return "successfulorderpage";
    }

    @GetMapping("/checkout")
    public String placeOrder(HttpSession session){

        Customer customer = (Customer)session.getAttribute("customer");

        if (customer==null){
            return "redirect:/auth";
        }

        orderServiceInterface.placeOrder(customer);

        return "redirect:/order/successful";
    }
}
