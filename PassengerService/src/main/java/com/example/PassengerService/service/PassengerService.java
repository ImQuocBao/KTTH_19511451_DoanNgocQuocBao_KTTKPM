package com.example.PassengerService.service;

import com.example.PassengerService.VO.ResponseTemplateVO;
import com.example.PassengerService.entity.Billing;
import com.example.PassengerService.entity.Passenger;
import com.example.PassengerService.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ResponseTemplateVO getPassengerWithBilling(Integer passengerId)
    {
        System.out.println("start api billing");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Passenger passenger = passengerRepository.findPassengerById(passengerId);

        Billing billing = restTemplate.getForObject("http://localhost:8080/billing/passenger/" + passengerId, Billing.class);

        System.out.println("meo" + billing);

        vo.setPassenger(passenger);
        vo.setBilling(billing);

        return vo;
    }

}
