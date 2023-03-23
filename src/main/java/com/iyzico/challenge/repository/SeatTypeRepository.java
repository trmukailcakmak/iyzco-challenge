package com.iyzico.challenge.repository;

import com.iyzico.challenge.entity.SeatTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatTypeEntity, Integer> {
}
