package com.example.carstore.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String make;
    private String model;
    private String description;
    private int year;
    private String imageUrl;
    private double price;
    private int quantity;


    public Car(String make, String model, String description, int year, double price, int quantity) {
        this.make=make;
        this.model=model;
        this.description=description;
        this.year=year;
        this.price=price;
        this.quantity=quantity;
    }
}
