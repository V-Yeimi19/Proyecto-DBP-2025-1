package com.example.watchapp.StatusHistory.Infrastructure;

import com.example.watchapp.StatusHistory.domain.StatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusHistoryRepository extends JpaRepository<StatusHistory, Long> {
    List<StatusHistory> findByIncidentId(Long incidentId);
}

