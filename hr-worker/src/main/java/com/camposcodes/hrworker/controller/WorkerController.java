package com.camposcodes.hrworker.controller;

import com.camposcodes.hrworker.entity.Worker;
import com.camposcodes.hrworker.repository.WorkerRepository;
import com.camposcodes.hrworker.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value="/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = workerService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = workerService.findById(id);
        return ResponseEntity.ok(worker);
    }
}
