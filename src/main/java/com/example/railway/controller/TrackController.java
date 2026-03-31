package com.example.railway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.railway.entity.Track;
import com.example.railway.service.TrackService;

@RestController
@RequestMapping("/api/tracks")
@CrossOrigin(origins = "http://localhost:5174")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping
    public List<Track> getTracks(){
        return trackService.getAllTracks();
    }

    @PostMapping
    public Track addTrack(@RequestBody Track track){
        return trackService.addTrack(track);
    }

    @PutMapping("/{id}")
    public Track updateTrack(@PathVariable Long id, @RequestBody Track track){
        return trackService.updateTrack(id, track);
    }

    @DeleteMapping("/{id}")
    public void deleteTrack(@PathVariable Long id){
        trackService.deleteTrack(id);
    }
}