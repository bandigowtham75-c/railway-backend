package com.example.railway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.railway.entity.Alert;
import com.example.railway.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping
    public List<Alert> getAlerts(){
        return alertService.getAllAlerts();
    }

    @PostMapping
    public Alert addAlert(@RequestBody Alert alert){
        return alertService.addAlert(alert);
    }
}
