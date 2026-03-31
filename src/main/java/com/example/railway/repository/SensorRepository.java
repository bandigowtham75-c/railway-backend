package com.example.railway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.railway.entity.SensorData;

public interface SensorRepository extends JpaRepository<SensorData, Long> {

}