package com.example.carstore.controllers;

import com.example.carstore.entities.CarPart;
import com.example.carstore.services.CarPartServiceInterface;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarPartController {
    @Autowired
    CarPartServiceInterface carPartServiceInterface;

    @GetMapping("/carparts")
    public String getCarParts(HttpSession session){
        List<CarPart>carParts = carPartServiceInterface.getCarParts();

        session.setAttribute("carParts",carParts);

        return "carpartpage";
    }


    @PostMapping("/find/carpart")
    public  String findCarPartsByName(HttpSession session, HttpServletRequest request){

        String name= request.getParameter("name");
        List<CarPart>carParts = carPartServiceInterface.getCarPartsByName(name);


        session.setAttribute("carParts",carParts);

        return "carpartpage";
    }
}
