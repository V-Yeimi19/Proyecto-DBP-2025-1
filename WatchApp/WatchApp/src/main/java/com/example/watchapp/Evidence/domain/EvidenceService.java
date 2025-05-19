package com.example.watchapp.Evidence.domain;

import com.example.watchapp.Evidence.Infrastructure.EvidenceRepository;
import com.example.watchapp.Evidence.dto.EvidenceDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvidenceService {
    @Autowired
    private EvidenceRepository evidenceRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EvidenceDTO createEvidence(EvidenceDTO evidenceDTO) {
        Evidence evidence = modelMapper.map(evidenceDTO, Evidence.class);
        Evidence savedEvidence = evidenceRepository.save(evidence);
        return modelMapper.map(savedEvidence, EvidenceDTO.class);
    }

    public List<EvidenceDTO> getAllEvidence() {
        return evidenceRepository.findAll().stream()
                .map(evidence -> modelMapper.map(evidence, EvidenceDTO.class))
                .collect(Collectors.toList());
    }

    public EvidenceDTO getEvidenceById(Long id) {
        Evidence evidence = evidenceRepository.findById(id).orElseThrow(() -> new RuntimeException("Evidence not found"));
        return modelMapper.map(evidence, EvidenceDTO.class);
    }

    public EvidenceDTO updateEvidence(Long id, EvidenceDTO evidenceDTO) {
        Evidence evidence = evidenceRepository.findById(id).orElseThrow(() -> new RuntimeException("Evidence not found"));
        modelMapper.map(evidenceDTO, evidence);
        evidenceRepository.save(evidence);
        return modelMapper.map(evidence, EvidenceDTO.class);
    }

    public void deleteEvidence(Long id) {
        evidenceRepository.deleteById(id);
    }
}

