package com.example.carstore.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


}
