package com.example.watchapp.Evidence.application;

import com.example.watchapp.Evidence.domain.EvidenceService;
import com.example.watchapp.Evidence.dto.EvidenceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidence")
public class EvidenceController {

    @Autowired
    private EvidenceService evidenceService;

    // Create Evidence
    @PostMapping
    public ResponseEntity<EvidenceDTO> createEvidence(@RequestBody EvidenceDTO evidenceDTO) {
        EvidenceDTO createdEvidence = evidenceService.createEvidence(evidenceDTO);
        return ResponseEntity.ok(createdEvidence);
    }

    // Get All Evidence
    @GetMapping
    public ResponseEntity<List<EvidenceDTO>> getAllEvidence() {
        List<EvidenceDTO> evidenceList = evidenceService.getAllEvidence();
        return ResponseEntity.ok(evidenceList);
    }

    // Get Evidence by ID
    @GetMapping("/{id}")
    public ResponseEntity<EvidenceDTO> getEvidenceById(@PathVariable Long id) {
        EvidenceDTO evidence = evidenceService.getEvidenceById(id);
        return ResponseEntity.ok(evidence);
    }

    // Update Evidence
    @PutMapping("/{id}")
    public ResponseEntity<EvidenceDTO> updateEvidence(@PathVariable Long id, @RequestBody EvidenceDTO evidenceDTO) {
        EvidenceDTO updatedEvidence = evidenceService.updateEvidence(id, evidenceDTO);
        return ResponseEntity.ok(updatedEvidence);
    }

    // Delete Evidence
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvidence(@PathVariable Long id) {
        evidenceService.deleteEvidence(id);
        return ResponseEntity.noContent().build();
    }
}

