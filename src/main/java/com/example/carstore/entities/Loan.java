package com.example.carstore.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Customer customer;
    @OneToOne
    private Car car;
    private double loanAmount;
    private double downPayment;
    private double interestRate;
    private int durationInMonths;
    private double monthlyPayment;
    private boolean status;

}
