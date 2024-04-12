package com.keyin.server.controller;

import com.keyin.server.entity.Car;
import com.keyin.server.entity.CarSearchCriteria;
import com.keyin.server.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/search")
    public List<Car> searchCars(
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) Double mileage,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String fuelType,
            @RequestParam(required = false) String transmission,
            @RequestParam(required = false) Double engineSize,
            @RequestParam(required = false) String location
    ) {
        CarSearchCriteria criteria = new CarSearchCriteria();
        criteria.setMake(make);
        criteria.setModel(model);
        criteria.setYear(year);
        criteria.setPrice(price);
        criteria.setMileage(mileage);
        criteria.setColor(color);
        criteria.setFuelType(fuelType);
        criteria.setTransmission(transmission);
        criteria.setEngineSize(engineSize);
        criteria.setLocation(location);

        return carService.searchCars(criteria);
    }
}
