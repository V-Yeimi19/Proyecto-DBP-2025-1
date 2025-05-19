package com.example.watchapp.StatusHistory.domain;

import com.example.watchapp.StatusHistory.Infrastructure.StatusHistoryRepository;
import com.example.watchapp.StatusHistory.dto.StatusHistoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusHistoryService {
    @Autowired
    private StatusHistoryRepository statusHistoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public StatusHistoryDTO createStatusHistory(StatusHistoryDTO statusHistoryDTO) {
        StatusHistory statusHistory = modelMapper.map(statusHistoryDTO, StatusHistory.class);
        StatusHistory savedHistory = statusHistoryRepository.save(statusHistory);
        return modelMapper.map(savedHistory, StatusHistoryDTO.class);
    }

    public List<StatusHistoryDTO> getHistoryByIncidentId(Long incidentId) {
        return statusHistoryRepository.findByIncidentId(incidentId).stream()
                .map(history -> modelMapper.map(history, StatusHistoryDTO.class))
                .collect(Collectors.toList());
    }
}
