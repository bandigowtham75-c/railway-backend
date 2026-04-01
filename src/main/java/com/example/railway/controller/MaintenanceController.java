package com.example.railway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.railway.entity.Maintenance;
import com.example.railway.repository.MaintenanceRepository;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceRepository repo;

    @GetMapping
    public List<Maintenance> getAll(){
        return repo.findAll();
    }

    @PostMapping
    public Maintenance add(@RequestBody Maintenance m){
        return repo.save(m);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }

    @PutMapping("/{id}")
    public Maintenance updateStatus(@PathVariable Long id){

        Maintenance m = repo.findById(id).orElse(null);

        if(m != null){
            m.setStatus("Completed");
            repo.save(m);
        }

        return m;
    }
    
    
}
