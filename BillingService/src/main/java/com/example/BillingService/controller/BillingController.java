package com.example.BillingService.controller;

import com.example.BillingService.entity.Billing;
import com.example.BillingService.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/")
    public Billing addBilling(@RequestBody Billing billing) {
        return billingService.addBilling(billing);
    }

    @GetMapping("/{id}")
    public Billing getBillingById(@PathVariable("id") Integer id) {
        return billingService.getBillingById(id);
    }

    @GetMapping("/passenger/{passengerId}")
    public Billing getBillingByPassengerId(@PathVariable("passengerId") String passengerId) {
        return billingService.getBillingByPassengerId(passengerId);
    }
}
