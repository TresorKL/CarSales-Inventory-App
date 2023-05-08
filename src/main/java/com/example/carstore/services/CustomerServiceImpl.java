package com.example.carstore.services;

import com.example.carstore.entities.Cart;
import com.example.carstore.entities.Customer;
import com.example.carstore.repositories.CartRepo;
import com.example.carstore.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerServiceInterface {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CartRepo cartRepo;

    @Override
    public Customer createCustomerAccount(Customer customer) {
        Cart cart = new Cart();
        cartRepo.save(cart);
        customer.setCart(cart);
        return customerRepo.save(customer);
    }
}
