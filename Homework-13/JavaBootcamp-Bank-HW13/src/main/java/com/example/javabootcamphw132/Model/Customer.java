package com.example.javabootcamphw132.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer {
    private int id;
    private String username;
    private double balance;
}
