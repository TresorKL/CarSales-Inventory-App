package com.example.carstore.services;

import com.example.carstore.entities.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CarPartServiceInterface {

    List<CarPart> getCarParts();

    List<CarPart> getCarPartsByName(String name);
}
