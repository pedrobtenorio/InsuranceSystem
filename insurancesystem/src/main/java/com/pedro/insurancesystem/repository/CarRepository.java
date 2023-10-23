package com.pedro.insurancesystem.repository;

import com.pedro.insurancesystem.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Override
    List<Car> findAll();

    Optional<Car> findById(Long id);
}
