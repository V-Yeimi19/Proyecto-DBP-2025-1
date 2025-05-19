package com.example.watchapp.StatusHistory.application;

import com.example.watchapp.StatusHistory.domain.StatusHistoryService;
import com.example.watchapp.StatusHistory.dto.StatusHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status-history")
public class StatusHistoryController {

    @Autowired
    private StatusHistoryService statusHistoryService;

    // Create Status History
    @PostMapping
    public ResponseEntity<StatusHistoryDTO> createStatusHistory(@RequestBody StatusHistoryDTO statusHistoryDTO) {
        StatusHistoryDTO createdHistory = statusHistoryService.createStatusHistory(statusHistoryDTO);
        return ResponseEntity.ok(createdHistory);
    }

    // Get Status History by Incident ID
    @GetMapping("/incident/{incidentId}")
    public ResponseEntity<List<StatusHistoryDTO>> getHistoryByIncidentId(@PathVariable Long incidentId) {
        List<StatusHistoryDTO> historyList = statusHistoryService.getHistoryByIncidentId(incidentId);
        return ResponseEntity.ok(historyList);
    }
}
