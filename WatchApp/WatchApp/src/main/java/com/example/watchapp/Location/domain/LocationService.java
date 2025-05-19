package com.example.watchapp.Location.domain;

import com.example.watchapp.Location.Infrastructure.LocationRepository;
import com.example.watchapp.Location.dto.LocationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Create Location
    public LocationDTO createLocation(LocationDTO locationDTO) {
        Location location = modelMapper.map(locationDTO, Location.class);
        Location savedLocation = locationRepository.save(location);
        return modelMapper.map(savedLocation, LocationDTO.class);
    }

    // Get All Locations
    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(location -> modelMapper.map(location, LocationDTO.class))
                .collect(Collectors.toList());
    }

    // Get Location by ID
    public LocationDTO getLocationById(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Location not found"));
        return modelMapper.map(location, LocationDTO.class);
    }

    // Update Location
    public LocationDTO updateLocation(Long id, LocationDTO locationDTO) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Location not found"));
        modelMapper.map(locationDTO, location);
        locationRepository.save(location);
        return modelMapper.map(location, LocationDTO.class);
    }

    // Delete Location
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}

