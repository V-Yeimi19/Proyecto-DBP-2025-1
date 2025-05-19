package com.example.watchapp.StatusHistory.domain;

import com.example.watchapp.Incident.domain.Incident;
import com.example.watchapp.Incident.domain.Status;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "status_history")
public class StatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status previousStatus;

    @Enumerated(EnumType.STRING)
    private Status newStatus;

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "incident_id")
    private Incident incident;
}
