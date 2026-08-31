package com.camposcodes.hrpayroll.service;

import com.camposcodes.hrpayroll.entity.Payment;
import com.camposcodes.hrpayroll.entity.Worker;
import com.camposcodes.hrpayroll.exception.ResourceNotFoundException;
import com.camposcodes.hrpayroll.feignClient.WorkerFeignClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
        Worker worker;
        try {
            worker = workerFeignClient.findById(workerId).getBody();
        } catch (FeignException.NotFound e) {
            throw new ResourceNotFoundException("Trabalhador não encontrado, id: " + workerId + " - Worker not found, id: " + workerId);
        }
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
