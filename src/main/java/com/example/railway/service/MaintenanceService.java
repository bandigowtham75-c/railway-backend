package com.example.railway.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.railway.entity.Maintenance;
import com.example.railway.repository.MaintenanceRepository;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository repo;

    public List<Maintenance> getAll() {
        return repo.findAll();
    }

    public Maintenance save(Maintenance m) {
        return repo.save(m);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    
}