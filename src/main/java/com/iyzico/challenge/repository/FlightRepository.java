package com.iyzico.challenge.repository;

import com.iyzico.challenge.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlightRepository extends JpaRepository<FlightEntity, Integer> {
}
