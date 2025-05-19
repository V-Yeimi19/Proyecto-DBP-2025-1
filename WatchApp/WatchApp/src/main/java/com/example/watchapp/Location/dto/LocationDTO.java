package com.example.watchapp.Location.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private Long id;
    private String department;
    private String province;
    private String district;
    private String street;
    private Double latitude;
    private Double longitude;
}
