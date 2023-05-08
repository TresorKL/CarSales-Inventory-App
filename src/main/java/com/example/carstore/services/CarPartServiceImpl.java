package com.example.carstore.services;

import com.example.carstore.entities.Car;
import com.example.carstore.entities.CarPart;
import com.example.carstore.repositories.CarPartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarPartServiceImpl implements CarPartServiceInterface {


    @Autowired
    CarPartRepo carPartRepo;

    @Override
    public List<CarPart> getCarParts() {
        return carPartRepo.findAll();
    }

    @Override
    public List<CarPart> getCarPartsByName(String name) {
        List<CarPart>carParts=carPartRepo.findAll();
        List<CarPart>carPartsFound =new ArrayList<>();
        for (CarPart carPart:carParts){
            if (carPart.getName().toLowerCase().contains(name.toLowerCase())){
                carPartsFound.add(carPart);
            }
        }

        return carPartsFound;
    }


}
