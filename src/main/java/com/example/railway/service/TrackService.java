package com.example.railway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.railway.entity.Track;
import com.example.railway.repository.TrackRepository;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public List<Track> getAllTracks(){
        return trackRepository.findAll();
    }

    public Track addTrack(Track track){
        return trackRepository.save(track);
    }

    public Track updateTrack(Long id, Track newTrack){

        Track track = trackRepository.findById(id).orElseThrow();

        track.setName(newTrack.getName());
        track.setLocation(newTrack.getLocation());
        track.setStatus(newTrack.getStatus());

        return trackRepository.save(track);
    }

    public void deleteTrack(Long id){
        trackRepository.deleteById(id);
    }
}