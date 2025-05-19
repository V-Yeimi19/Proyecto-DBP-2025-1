package com.example.watchapp.Evidence.domain;


import com.example.watchapp.Incident.domain.Incident;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "evidence")
public class Evidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileUrl;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    @ManyToOne
    @JoinColumn(name = "incident_id")
    private Incident incident;
}