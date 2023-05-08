package com.example.carstore.repositories;

import com.example.carstore.entities.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPartRepo extends JpaRepository<CarPart,Long> {


}
