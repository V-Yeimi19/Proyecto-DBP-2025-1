package com.example.watchapp.Notification.application;

import com.example.watchapp.Notification.domain.NotificationService;
import com.example.watchapp.Notification.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Create Notification
    @PostMapping
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO notificationDTO) {
        NotificationDTO createdNotification = notificationService.createNotification(notificationDTO);
        return ResponseEntity.ok(createdNotification);
    }

    // Get Notifications by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationDTO>> getNotificationsByUserId(@PathVariable Long userId) {
        List<NotificationDTO> notifications = notificationService.getNotificationsByUserId(userId);
        return ResponseEntity.ok(notifications);
    }

    // Get Notifications by Incident ID
    @GetMapping("/incident/{incidentId}")
    public ResponseEntity<List<NotificationDTO>> getNotificationsByIncidentId(@PathVariable Long incidentId) {
        List<NotificationDTO> notifications = notificationService.getNotificationsByIncidentId(incidentId);
        return ResponseEntity.ok(notifications);
    }
}