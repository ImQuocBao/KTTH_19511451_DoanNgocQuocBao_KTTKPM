package com.example.PassengerService.VO;

import com.example.PassengerService.entity.Billing;
import com.example.PassengerService.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO implements Serializable {

    private Billing billing;
    private Passenger passenger;

}
