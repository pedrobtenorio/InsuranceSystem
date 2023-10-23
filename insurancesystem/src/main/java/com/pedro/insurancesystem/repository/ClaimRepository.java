package com.pedro.insurancesystem.repository;

import com.pedro.insurancesystem.domain.Car;
import com.pedro.insurancesystem.domain.Claim;
import com.pedro.insurancesystem.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
    Optional<Claim> findByDriver(Driver driver);
    Optional<Claim> findByCar(Car car);
}
