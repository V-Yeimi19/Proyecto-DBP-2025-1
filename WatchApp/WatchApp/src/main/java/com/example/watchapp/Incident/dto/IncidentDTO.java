package com.example.watchapp.Incident.dto;

import com.example.watchapp.Incident.domain.IncidentType;
import com.example.watchapp.Incident.domain.Priority;
import com.example.watchapp.Incident.domain.Status;
import lombok.Data;

@Data
public class IncidentDTO {
    private Long id;
    private IncidentType type;
    private String description;
    private Priority priority;
    private Status status;
    private String emoji;
    private String timestamp;
    private Long userId;
    private Long locationId;
}

