package com.example.carstore.controllers;

import com.example.carstore.entities.Admin;
import com.example.carstore.entities.Customer;
import com.example.carstore.services.AuthServiceInterface;
import com.example.carstore.services.CarServiceInterface;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    AuthServiceInterface authServiceInterface;
    @Autowired
    CarServiceInterface carServiceInterface;

    @GetMapping("/admin")
    public String getAdminPage(HttpSession session){

        Admin admin = (Admin) session.getAttribute("admin");
        if (admin!=null){
            session.setAttribute("cars", carServiceInterface.getCars());
            return "adminpage";
        }else {
            return "redirect:/";
        }

    }

    @GetMapping("/auth")
    public String getLoginPage(){
        return "loginpage";
    }

    @PostMapping("/login")
    public String handleLogin(HttpSession session, @RequestParam String email, @RequestParam String password) {
        // Handle the login request using the email and password parameters

        Admin admin = authServiceInterface.loginAdmin(password,email);
        Customer customer = authServiceInterface.loginCustomer(password,email);
        if (admin!=null){
            session.setAttribute("userType","admin");
            session.setAttribute("admin",admin);
            return "redirect:/admin";

        }else if(customer!=null){
            session.setAttribute("userType","customer");
            session.setAttribute("customer",customer);
            return "redirect:/";
        }else {
            return "loginpage";
        }


//        return "login-success";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
