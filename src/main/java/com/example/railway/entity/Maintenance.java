package com.example.railway.entity;

import jakarta.persistence.*;

@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long trackId;
    private String engineer;
    private String status;
    private String repairDate;

    public Long getId() { return id; }

    public Long getTrackId() { return trackId; }
    public void setTrackId(Long trackId) { this.trackId = trackId; }

    public String getEngineer() { return engineer; }
    public void setEngineer(String engineer) { this.engineer = engineer; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRepairDate() { return repairDate; }
    public void setRepairDate(String repairDate) { this.repairDate = repairDate; }
}