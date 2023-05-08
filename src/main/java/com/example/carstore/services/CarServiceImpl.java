package com.example.carstore.services;

import com.example.carstore.entities.Car;
import com.example.carstore.repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarServiceInterface {

    @Autowired
    CarRepo carRepo;

    @Override
    public List<Car> getCars() {
        return carRepo.findAll();
    }

    @Override
    public List<Car> getCarByMake(String make) {

        List<Car>cars=carRepo.findAll();
        List<Car>carsFound =new ArrayList<>();
        for (Car car:cars){
            if (car.getMake().toLowerCase().contains(make.toLowerCase())){
                carsFound.add(car);
            }
        }

        return carsFound;
    }

    @Override
    public List<Car> getCarByPriceRange(double from, double to) {

        List<Car>cars=carRepo.findAll();
        List<Car>carsFound =new ArrayList<>();
        for (Car car:cars){
            if (car.getPrice()>=from && car.getPrice()<=to){
                carsFound.add(car);
            }
        }

        return carsFound;
    }


}
