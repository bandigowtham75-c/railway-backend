package com.example.railway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.railway.entity.Track;
import com.example.railway.repository.TrackRepository;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin("*")
public class ReportController {

    @Autowired
    private TrackRepository repo;

    @GetMapping("/cracks")
    public List<Track> crackReport(){
        return repo.findAll()
                   .stream()
                   .filter(t -> "CRACK".equals(t.getStatus()))
                   .toList();
    }
}