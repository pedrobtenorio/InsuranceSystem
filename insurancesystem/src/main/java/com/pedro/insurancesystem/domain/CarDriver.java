package com.pedro.insurancesystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car_drivers")
@Getter
@Setter
public class CarDriver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Car car;
    @OneToOne
    private Driver driver;
    private boolean isMainDriver;

}