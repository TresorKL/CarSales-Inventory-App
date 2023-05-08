package com.example.carstore.services;

import com.example.carstore.entities.Car;

import java.util.List;

public interface CarServiceInterface {


    List<Car> getCars();
    List<Car>getCarByMake(String make);
    List<Car>getCarByPriceRange(double from, double to);

}
