package com.example.carstore.controllers;

import com.example.carstore.entities.Customer;
import com.example.carstore.services.CustomerServiceInterface;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    CustomerServiceInterface customerServiceInterface;

    @GetMapping("/newcustomer")
    public String getCustomerForm(){
        return "customer-account-form";
    }

    @PostMapping("/client/account")
    public String newClientAccount(HttpSession session,@ModelAttribute("user") Customer customer){

        Customer newCustomer=customerServiceInterface.createCustomerAccount(customer);

        return "redirect:/";
    }
}
