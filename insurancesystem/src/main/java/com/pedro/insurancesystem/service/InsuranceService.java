package com.pedro.insurancesystem.service;


import com.pedro.insurancesystem.domain.*;
import com.pedro.insurancesystem.repository.ClaimRepository;
import com.pedro.insurancesystem.repository.InsuranceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final CarService carService;
    private final ClaimRepository claimRepository;
    private final DriverService driverService;
    private final CustomerService customerService;

    public InsuranceService(InsuranceRepository insuranceRepository, CarService carService, ClaimRepository claimRepository, DriverService driverService, CustomerService customerService) {

        this.insuranceRepository = insuranceRepository;
        this.carService = carService;
        this.claimRepository = claimRepository;
        this.driverService = driverService;
        this.customerService = customerService;
    }

    public Insurance createInsuranceBudget(Insurance insurance) {
        insurance.setCustomer(loadCustomer(insurance));
        insurance.setCar(loadCar(insurance));
        insurance.setBudget(calculateBudge(insurance));

        return insuranceRepository.save(insurance);
    }

    public Insurance getInsuranceById(Long insuranceId) {
        Optional<Insurance> optionalInsurance = insuranceRepository.findById(insuranceId);
        if (optionalInsurance.isPresent()) {
            return optionalInsurance.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insurance with ID " + insuranceId + " not found");
    }

    public double calculateBudge(Insurance insurance) {
        double baseBudget = 0.06;
        baseBudget += applyRiskFactors(insurance);
        return baseBudget * insurance.getCar().getFipeValue();
    }

    public Insurance updateInsurance(Long insuranceId, Insurance updatedInsurance) {
        Optional<Insurance> optionalInsurance = insuranceRepository.findById(insuranceId);

        if (optionalInsurance.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insurance with ID " + insuranceId + " not found");
        }

        Insurance existingInsurance = optionalInsurance.get();

        existingInsurance.setActive(updatedInsurance.isActive());
        existingInsurance.setCar(loadCar(updatedInsurance));
        existingInsurance.setCustomer(loadCustomer(updatedInsurance));
        existingInsurance.setUpdatedAt(new Date());
        var baseBudget = calculateBudge(existingInsurance);
        existingInsurance.setBudget(baseBudget);
        return insuranceRepository.save(existingInsurance);
    }

    private double applyRiskFactors(Insurance insurance) {
        double riskFactor = 0.0;

        if (isDriverYoung(insurance)) {
            riskFactor += 0.02;
        }
        if (hasDriverClaim(insurance)) {
            riskFactor += 0.02;
        }
        if (hasCarClaim(insurance)) {
            riskFactor += 0.02;
        }

        return riskFactor;
    }

    private boolean isDriverYoung(Insurance insurance) {
        Driver driver = driverService.getDriverInfo(insurance);
        var driverAge = driverService.getDriverAge(driver.getBirthdate());
        return driverAge >= 18 && driverAge <= 25;
    }

    private boolean hasDriverClaim(Insurance insurance) {
        Driver driver = driverService.getDriverInfo(insurance);
        Optional<Claim> claimOptional = claimRepository.findByDriver(driver);
        return claimOptional.isPresent();

    }

    private boolean hasCarClaim(Insurance insurance) {
        Car car = insurance.getCar();
        Optional<Claim> claimOptional = claimRepository.findByCar(car);
        return claimOptional.isPresent();
    }


    public void deleteInsurance(Long insuranceId) {
        Optional<Insurance> optionalInsurance = insuranceRepository.findById(insuranceId);
        if (optionalInsurance.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insurance with ID " + insuranceId + " not found");
        }
        insuranceRepository.deleteById(insuranceId);
    }

    public Car loadCar(Insurance insurance) {
        Optional<Car> optionalCar = carService.findById(insurance.getCar().getId());
        if (optionalCar.isEmpty()) {
            String errorMessage = "Car with ID " + insurance.getCar().getId() + " does not exist. Create the car first.";
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,errorMessage);
        }
        return optionalCar.get();
    }
    public Customer loadCustomer(Insurance insurance) {
        Optional<Customer> optionalCustomer = customerService.findById(insurance.getCar().getId());
        if (optionalCustomer.isEmpty()) {
            String errorMessage = "Customer ID " + insurance.getCustomer().getId() + " does not exist. Create the customer first.";
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
        return optionalCustomer.get();
    }

}

