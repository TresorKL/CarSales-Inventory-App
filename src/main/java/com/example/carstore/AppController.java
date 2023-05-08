package com.example.carstore;

import com.example.carstore.services.CarServiceInterface;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {


    @Autowired
    CarServiceInterface carServiceInterface;

    @GetMapping("/")
    public String landingPage(HttpSession session){

        session.setAttribute("cars", carServiceInterface.getCars());

        return "index";
    }
}
