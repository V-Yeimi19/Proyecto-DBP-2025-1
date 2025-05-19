package com.example.watchapp.domain;


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