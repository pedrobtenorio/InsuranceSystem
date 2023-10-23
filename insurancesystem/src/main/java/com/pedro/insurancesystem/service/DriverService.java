package com.pedro.insurancesystem.service;

import com.pedro.insurancesystem.domain.Car;
import com.pedro.insurancesystem.domain.CarDriver;
import com.pedro.insurancesystem.domain.Driver;
import com.pedro.insurancesystem.domain.Insurance;
import com.pedro.insurancesystem.repository.CarDriverRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class DriverService {
    private final CarDriverRepository carDriverRepository;
    public DriverService(CarDriverRepository carDriverRepository) {
        this.carDriverRepository = carDriverRepository;
    }

    public int getDriverAge(Date birthdate) {
        LocalDate birthdateLocal = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthdateLocal, currentDate);

        return period.getYears();
    }

    public Driver getDriverInfo(Insurance insurance) {
        Car car = insurance.getCar();
        Optional<CarDriver> carDriverOptional = this.carDriverRepository.findByCar(car);
        if(carDriverOptional.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Relation with driver not found");
        }
        CarDriver carDriver = carDriverOptional.get();
        return carDriver.getDriver();
    }
}
