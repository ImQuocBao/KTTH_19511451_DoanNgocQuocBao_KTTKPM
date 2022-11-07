package com.example.BillingService.repository;

import com.example.BillingService.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {

    Billing findBillingByPassengerId(String passengerId);

}
