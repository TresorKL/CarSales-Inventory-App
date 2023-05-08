package com.example.carstore.services;

import com.example.carstore.entities.Admin;
import com.example.carstore.entities.Customer;

public interface AuthServiceInterface {

    public Admin loginAdmin(String password, String email);

    public Customer loginCustomer(String password, String email);
}
