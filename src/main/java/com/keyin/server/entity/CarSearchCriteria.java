package com.keyin.server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarSearchCriteria {
    private String make;
    private String model;
    private Integer year;
    private Double price;
    private Double mileage;
    private String color;
    private String fuelType;
    private String transmission;
    private Double engineSize;
    private String location;
}
