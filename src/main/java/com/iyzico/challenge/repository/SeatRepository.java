package com.iyzico.challenge.repository;

import com.iyzico.challenge.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, Integer> {
    public Optional<SeatEntity> findByFlight_IdEqualsAndSeatNumEquals(Integer flight,Integer seatNum);
}
