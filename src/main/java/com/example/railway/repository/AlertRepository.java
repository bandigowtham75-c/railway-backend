package com.example.railway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.railway.entity.Alert;

public interface AlertRepository extends JpaRepository<Alert, Long> {
}