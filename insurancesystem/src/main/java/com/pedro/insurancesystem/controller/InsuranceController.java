package com.pedro.insurancesystem.controller;

import com.pedro.insurancesystem.domain.Car;
import com.pedro.insurancesystem.domain.Insurance;
import com.pedro.insurancesystem.service.InsuranceService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    private final InsuranceService insuranceService;
    public InsuranceController(InsuranceService insuranceService){
        this.insuranceService = insuranceService;
    }

    @PostMapping("/budget")
    public Insurance createInsuranceBudget(@RequestBody Insurance insurance) {
        return insuranceService.createInsuranceBudget(insurance);
    }

    @GetMapping("/{insuranceId}")
    public Insurance getInsuranceById(@PathVariable Long insuranceId) {
        return insuranceService.getInsuranceById(insuranceId);
    }

    @PutMapping("/{insuranceId}")
    public Insurance updateInsurance(@PathVariable Long insuranceId, @RequestBody Insurance updatedInsurance) {
        return insuranceService.updateInsurance(insuranceId, updatedInsurance);
    }

    @DeleteMapping("/{insuranceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInsurance(@PathVariable Long insuranceId) {
        insuranceService.deleteInsurance(insuranceId);
    }

}
