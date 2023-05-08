package com.example.carstore.controllers;

import com.example.carstore.entities.Car;
import com.example.carstore.entities.CarPart;
import com.example.carstore.repositories.CarPartRepo;
import com.example.carstore.repositories.CarRepo;
import com.example.carstore.services.CarServiceInterface;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarServiceInterface carServiceInterface;

    @Autowired
    CarRepo carRepo;

    @Autowired
    CarPartRepo carPartRepo;

    @PostMapping("/find/bymake")
    public String findCarByMake(HttpSession session, HttpServletRequest request){

        String make= request.getParameter("make");

        List<Car>cars=carServiceInterface.getCarByMake(make);
        session.setAttribute("cars",cars);
        return "index";
    }

    @PostMapping("/find/price")
    public String findCarByPriceRange(HttpSession session, HttpServletRequest request){

        double from = Double.parseDouble(request.getParameter("from"));
        double to = Double.parseDouble(request.getParameter("to"));

        List<Car>cars=carServiceInterface.getCarByPriceRange(from,to);
        session.setAttribute("cars",cars);

        return "index";
    }

    @GetMapping("/product/{productType}/{id}")
    public String viewCarDetail(HttpSession session,@PathVariable String productType, @PathVariable Long id){

        if (productType.equals("car")){
            Car car = carRepo.findById(id).get();
            session.setAttribute("productType",productType);
            session.setAttribute("product",car);

        }else if (productType.equals("carpart")){
            CarPart carPart = carPartRepo.findById(id).get();
            session.setAttribute("productType",productType);
            session.setAttribute("product",carPart);
        }



        return "productdetail";
    }



}
