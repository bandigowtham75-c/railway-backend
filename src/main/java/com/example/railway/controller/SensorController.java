package com.example.railway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.railway.entity.SensorData;
import com.example.railway.repository.SensorRepository;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorRepository repo;

    @GetMapping
    public List<SensorData> getSensors(){
        return repo.findAll();
    }

    @PostMapping
    public SensorData save(@RequestBody SensorData data){
        return repo.save(data);
    }
}
