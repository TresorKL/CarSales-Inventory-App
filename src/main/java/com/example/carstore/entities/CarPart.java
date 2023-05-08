package com.example.carstore.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CarPart  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    private String manufacturer;
    private String imageUrl;
    private double price;
    private int quantity;

    public CarPart(String name, String description, String manufacturer, String imageUrl, double price, int quantity) {
        this.name=name;
        this.description=description;
        this.manufacturer=manufacturer;
        this.imageUrl=imageUrl;
        this.price=price;
        this.quantity=quantity;

    }
}
