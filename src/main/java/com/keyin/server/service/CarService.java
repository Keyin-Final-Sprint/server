package com.keyin.server.service;

import com.keyin.server.entity.Car;
import com.keyin.server.entity.CarSearchCriteria;
import com.keyin.server.repository.CarRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> searchCars(CarSearchCriteria criteria) {
        return carRepository.findAll((Specification<Car>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getMake() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("make")), "%" + criteria.getMake().toLowerCase() + "%"));
            }
            if (criteria.getModel() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("model")), "%" + criteria.getModel().toLowerCase() + "%"));
            }
            if (criteria.getYear() != null) {
                predicates.add(criteriaBuilder.equal(root.get("year"), criteria.getYear()));
            }
            if (criteria.getPrice() != null) {
                predicates.add(criteriaBuilder.equal(root.get("price"), criteria.getPrice()));
            }
            if (criteria.getMileage() != null) {
                predicates.add(criteriaBuilder.equal(root.get("mileage"), criteria.getMileage()));
            }
            if (criteria.getColor() != null) {
                predicates.add(criteriaBuilder.equal(root.get("color"), criteria.getColor()));
            }
            if (criteria.getFuelType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("fuelType"), criteria.getFuelType()));
            }
            if (criteria.getTransmission() != null) {
                predicates.add(criteriaBuilder.equal(root.get("transmission"), criteria.getTransmission()));
            }
            if (criteria.getEngineSize() != null) {
                predicates.add(criteriaBuilder.equal(root.get("engineSize"), criteria.getEngineSize()));
            }
            if (criteria.getLocation() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("location")), "%" + criteria.getLocation().toLowerCase() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
