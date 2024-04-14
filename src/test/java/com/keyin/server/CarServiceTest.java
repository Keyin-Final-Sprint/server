package com.keyin.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;
import com.keyin.server.entity.Car;
import com.keyin.server.entity.CarSearchCriteria;
import com.keyin.server.repository.CarRepository;
import com.keyin.server.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;

public class CarServiceTest {
    @Mock
    private CarRepository carRepository;
    @InjectMocks
    private CarService carService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearchCars() {
        Car car = new Car();
        car.setMake("Toyota");
        when(carRepository.findAll(any(Specification.class))).thenReturn(Arrays.asList(car));

        CarSearchCriteria criteria = new CarSearchCriteria();
        criteria.setMake("Toyota");
        List<Car> cars = carService.searchCars(criteria);

        assertFalse(cars.isEmpty());
        assertEquals("Toyota", cars.get(0).getMake());
    }
}
