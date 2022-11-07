package com.example.PassengerService.controller;

import com.example.PassengerService.VO.ResponseTemplateVO;
import com.example.PassengerService.entity.Passenger;
import com.example.PassengerService.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/")
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return passengerService.addPassenger(passenger);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getPassengerWithBilling(@PathVariable("id") Integer passengerId) {
        return passengerService.getPassengerWithBilling(passengerId);
    }

}
