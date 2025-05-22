package com.example.watchapp.Incident.domain;

import com.example.watchapp.Incident.Infrastructure.IncidentRepository;
import com.example.watchapp.Incident.dto.IncidentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationEventPublisher;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private ModelMapper modelMapper;

    public IncidentDTO createIncident(IncidentDTO incidentDTO) {
        Incident incident = modelMapper.map(incidentDTO, Incident.class);
        Incident savedIncident = incidentRepository.save(incident);

        // 🔔 Publicar evento después de guardar
        eventPublisher.publishEvent(new IncidentCreatedEvent(this, savedIncident));

        return modelMapper.map(savedIncident, IncidentDTO.class);
    }


    public List<IncidentDTO> getAllIncidents() {
        return incidentRepository.findAll().stream()
                .map(incident -> modelMapper.map(incident, IncidentDTO.class))
                .collect(Collectors.toList());
    }

    public IncidentDTO getIncidentById(Long id) {
        Incident incident = incidentRepository.findById(id).orElseThrow(() -> new RuntimeException("Incident not found"));
        return modelMapper.map(incident, IncidentDTO.class);
    }

    public IncidentDTO updateIncident(Long id, IncidentDTO incidentDTO) {
        Incident incident = incidentRepository.findById(id).orElseThrow(() -> new RuntimeException("Incident not found"));
        modelMapper.map(incidentDTO, incident);
        incidentRepository.save(incident);
        return modelMapper.map(incident, IncidentDTO.class);
    }

    public void deleteIncident(Long id) {
        incidentRepository.deleteById(id);
    }
}

