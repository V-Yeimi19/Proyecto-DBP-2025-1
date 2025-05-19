package com.example.watchapp.Incident.Infrastructure;

import com.example.watchapp.Incident.domain.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> findByStatus(String status);
    List<Incident> findByPriority(String priority);
    List<Incident> findByType(String type);
}
