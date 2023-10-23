package com.pedro.insurancesystem.repository;

import com.pedro.insurancesystem.domain.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    Optional<Insurance> findById(Long id);
}
