package com.example.PassengerService.repository;

import com.example.PassengerService.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    @Query(value = "SELECT * FROM passenger where passengerId = ?1", nativeQuery = true)
    Passenger findPassengerById(Integer passengerId);

}
