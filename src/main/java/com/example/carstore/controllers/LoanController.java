package com.example.carstore.controllers;

import com.example.carstore.entities.Car;
import com.example.carstore.services.LoanServiceInterface;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoanController {

    @Autowired
    LoanServiceInterface loanServiceInterface;

    @PostMapping("/apply-loan")
    public String applyForLoan(HttpSession session, HttpServletRequest request){

        loanServiceInterface.createLoan(session,request);


        return "successful-loan-application";
    }
}
