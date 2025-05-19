package com.example.watchapp.Evidence.Infrastructure;

import com.example.watchapp.Evidence.domain.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    List<Evidence> findByIncidentId(Long incidentId);
}
