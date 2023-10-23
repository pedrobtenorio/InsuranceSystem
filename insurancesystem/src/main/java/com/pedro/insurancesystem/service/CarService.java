package com.pedro.insurancesystem.service;

import com.pedro.insurancesystem.domain.Car;
import com.pedro.insurancesystem.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> findById(Long carId) {
        return carRepository.findById(carId);
    }




}