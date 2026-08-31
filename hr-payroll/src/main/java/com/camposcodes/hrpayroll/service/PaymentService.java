package com.camposcodes.hrpayroll.service;

import com.camposcodes.hrpayroll.entity.Payment;
import com.camposcodes.hrpayroll.entity.Worker;
import com.camposcodes.hrpayroll.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("workerId", String.valueOf(workerId));

        Worker worker;
        try {
            worker = restTemplate.getForObject(workerHost + "/workers/{workerId}", Worker.class, uriVariables);
        } catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("Trabalhador não encontrado, id: " + workerId + " - Worker not found, id: " + workerId);
        }
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
