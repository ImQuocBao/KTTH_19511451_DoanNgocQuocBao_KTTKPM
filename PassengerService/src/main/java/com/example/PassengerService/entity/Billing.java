package com.example.PassengerService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Billing implements Serializable {
    private Integer id;
    private String Name;
    private Double price;
    private String passengerId;
}
