package com.example.railway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.railway.entity.Track;

public interface TrackRepository extends JpaRepository<Track, Long> {
	
	
}
