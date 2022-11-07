package com.example.BillingService.service;

import com.example.BillingService.entity.Billing;
import com.example.BillingService.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public Billing addBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public Billing getBillingById(Integer id) {
        return billingRepository.findById(id).get();
    }

    public Billing getBillingByPassengerId(String passengerId) {
        return billingRepository.findBillingByPassengerId(passengerId);
    }
}
