package com.example.carstore.services;

import com.example.carstore.entities.Car;
import com.example.carstore.entities.Customer;
import com.example.carstore.entities.Loan;
import com.example.carstore.repositories.CarRepo;
import com.example.carstore.repositories.CustomerRepo;
import com.example.carstore.repositories.LoanRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class LoanServiceImpl  implements LoanServiceInterface{

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    LoanRepo loanRepo;
    @Autowired
    CarRepo carRepo;

    @Override
    public List<Loan> getAllLoan() {
        return null;
    }

    @Override
    public Loan createLoan(HttpSession session, HttpServletRequest request) {
        Customer currentCustomer =(Customer) session.getAttribute("customer");
        Car currentCar = (Car) session.getAttribute("product");
        Customer customer = customerRepo.findById(currentCustomer.getId()).get();
        Car car= carRepo.findById(currentCar.getId()).get();

        double loanAmount= Double.parseDouble(request.getParameter("loanAmount"));
        double downPayment= Double.parseDouble(request.getParameter("downPayment"));
        double interestRate= Double.parseDouble(request.getParameter("interestRate"));
        double monthlyPayment= Double.parseDouble(request.getParameter("monthlyPayment"));
        int durationInMonths= Integer.parseInt(request.getParameter("durationInMonths"));

        Loan loan = new Loan();

        loan.setCustomer(customer);
        loan.setCar(car);
        loan.setStatus(false);
        loan.setLoanAmount(loanAmount);
        loan.setDownPayment(downPayment);
        loan.setInterestRate(interestRate);
        loan.setMonthlyPayment(monthlyPayment);
        loan.setDurationInMonths(durationInMonths);
        loanRepo.save(loan);

        return loan;

    }
}
