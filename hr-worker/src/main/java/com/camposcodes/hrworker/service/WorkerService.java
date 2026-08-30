package com.camposcodes.hrworker.service;

import com.camposcodes.hrworker.entity.Worker;
import com.camposcodes.hrworker.exception.ResourceNotFoundException;
import com.camposcodes.hrworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> findAll(){
        return workerRepository.findAll();
    }

    public Worker findById(Long id){
        return workerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trabalhador não encontrado, id: " + id + " - Worker not found, id: " + id));
    }
}
