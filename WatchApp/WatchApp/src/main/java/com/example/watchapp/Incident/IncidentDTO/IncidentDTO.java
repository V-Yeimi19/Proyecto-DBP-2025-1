package com.example.watchapp.Incident.IncidentDTO;

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
    private String reportedAt;
    private Long userId;
    private Long locationId;
}

