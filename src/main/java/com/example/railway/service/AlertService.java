package com.example.railway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.railway.entity.Alert;
import com.example.railway.repository.AlertRepository;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public List<Alert> getAllAlerts(){
        return alertRepository.findAll();
    }

    public Alert addAlert(Alert alert){
        return alertRepository.save(alert);
    }
}