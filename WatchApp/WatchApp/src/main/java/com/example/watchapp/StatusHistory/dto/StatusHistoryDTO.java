package com.example.watchapp.StatusHistory.dto;

import lombok.Data;

@Data
public class StatusHistoryDTO {
    private Long id;
    private String previousStatus;
    private String newStatus;
    private String updatedAt;
    private Long incidentId;
}