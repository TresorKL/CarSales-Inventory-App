package com.example.carstore.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_part_id")
    private CarPart carPart;

    private int quantity;
    private double amount;

    public double determineAmount(){
        double amount=0.0;
        if (car!=null){
            amount=car.getPrice()*getQuantity();
        }else if (carPart!=null){
            amount=carPart.getPrice()*getQuantity();
        }

        return amount;
    }


}
