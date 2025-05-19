package com.example.watchapp.Evidence.dto;

import lombok.Data;

@Data
public class EvidenceDTO {
    private Long id;
    private String fileUrl;
    private String fileType;
    private Long incidentId;
}
