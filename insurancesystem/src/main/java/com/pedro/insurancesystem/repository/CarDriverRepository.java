package com.pedro.insurancesystem.repository;


import com.pedro.insurancesystem.domain.Car;
import com.pedro.insurancesystem.domain.CarDriver;
import com.pedro.insurancesystem.domain.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarDriverRepository extends JpaRepository<CarDriver, Long> {
    Optional<CarDriver> findById(Long id);
    Optional<CarDriver> findByCar(Car car);
}
