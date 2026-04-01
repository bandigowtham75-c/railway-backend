package com.example.railway.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.railway.entity.Track;
import com.example.railway.service.TrackService;

@RestController
@RequestMapping("/api/tracks")   // 👈 changed from "/api" to "/api/tracks"
@CrossOrigin(origins = "https://railway-monitoring-system-frontend.onrender.com")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping                  // ✅ Now maps to GET /api/tracks
    public List<Track> getTracks() {
        return trackService.getAllTracks();
    }

    @PostMapping                 // ✅ Now maps to POST /api/tracks
    public Track addTrack(@RequestBody Track track) {
        return trackService.addTrack(track);
    }

    @PutMapping("/{id}")         // ✅ Now maps to PUT /api/tracks/{id}
    public Track updateTrack(@PathVariable Long id, @RequestBody Track track) {
        return trackService.updateTrack(id, track);
    }

    @DeleteMapping("/{id}")      // ✅ Now maps to DELETE /api/tracks/{id}
    public void deleteTrack(@PathVariable Long id) {
        trackService.deleteTrack(id);
    }
}