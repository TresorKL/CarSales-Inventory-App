package com.example.carstore.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany
    List<CartItem> items;


    private double totAmount;

    public double determineTotAmount(){
        List<CartItem>items =getItems();
        double totAmount=0.0;
        for (CartItem item:items){
            totAmount+=item.getAmount();
        }

        return totAmount;
    }






}
