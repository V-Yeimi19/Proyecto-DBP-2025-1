package com.example.watchapp.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String department;
    private String province;
    private String district;
    private String street;

    private Double latitude;
    private Double longitude;
}
