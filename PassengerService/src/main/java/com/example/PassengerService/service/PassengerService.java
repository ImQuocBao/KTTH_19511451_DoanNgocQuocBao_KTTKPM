package com.example.PassengerService.service;

import com.example.PassengerService.VO.ResponseTemplateVO;
import com.example.PassengerService.entity.Billing;
import com.example.PassengerService.entity.Passenger;
import com.example.PassengerService.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
    int count = 0;
    @Retryable(value = Exception.class, maxAttempts = 10, backoff = @Backoff(value = 1000))
    public ResponseTemplateVO getPassengerWithBilling(Integer passengerId)
    {
        System.out.println("recall" + ++count);

        ResponseTemplateVO vo = new ResponseTemplateVO();
        Passenger passenger = passengerRepository.findPassengerById(passengerId);

        Billing billing = restTemplate.getForObject("http://localhost:8080/billing/passenger/" + passengerId, Billing.class);

        vo.setPassenger(passenger);
        vo.setBilling(billing);

        return vo;
    }

}
