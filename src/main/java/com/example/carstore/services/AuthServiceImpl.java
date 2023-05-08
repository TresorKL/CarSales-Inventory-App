package com.example.carstore.services;

import com.example.carstore.entities.Admin;
import com.example.carstore.entities.Customer;
import com.example.carstore.repositories.AdminRepo;
import com.example.carstore.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthServiceInterface{

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Admin loginAdmin(String password, String email) {
        return adminRepo.findAdminByEmailAndPassword(email,password);
    }

    @Override
    public Customer loginCustomer(String password, String email) {
        return customerRepo.findByEmailAndPassword(email,password);
    }
}
