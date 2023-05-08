package com.example.carstore.services;


import com.example.carstore.entities.Customer;
import com.example.carstore.entities.Order;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface OrderServiceInterface {

    public List<Order> getOrders();
    public void placeOrder(Customer currentCustomer);
}
