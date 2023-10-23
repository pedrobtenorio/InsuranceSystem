package com.pedro.insurancesystem.service;


import com.pedro.insurancesystem.domain.Customer;
import com.pedro.insurancesystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Optional<Customer> findById(Long carId) {
        return this.customerRepository.findById(carId);
    }
}
