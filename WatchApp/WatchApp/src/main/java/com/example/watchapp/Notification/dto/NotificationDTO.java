package com.example.watchapp.Notification.dto;

import lombok.Data;

@Data
public class NotificationDTO {
    private Long id;
    private String message;
    private String status;
    private String sentAt;
    private Long userId;
    private Long incidentId;
}
