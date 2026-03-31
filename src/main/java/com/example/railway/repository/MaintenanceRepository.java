package com.example.railway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.railway.entity.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}