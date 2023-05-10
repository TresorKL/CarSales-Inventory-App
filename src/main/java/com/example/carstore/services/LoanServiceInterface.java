package com.example.carstore.services;

import com.example.carstore.entities.Loan;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface LoanServiceInterface {

    List<Loan>getAllLoan();
    Loan createLoan(HttpSession session, HttpServletRequest request);

}
