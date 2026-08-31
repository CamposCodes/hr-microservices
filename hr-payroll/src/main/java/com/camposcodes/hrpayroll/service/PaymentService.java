package com.camposcodes.hrpayroll.service;

import com.camposcodes.hrpayroll.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days) {
        return new Payment("Nome Mock", 200.0, days);
    }
}
