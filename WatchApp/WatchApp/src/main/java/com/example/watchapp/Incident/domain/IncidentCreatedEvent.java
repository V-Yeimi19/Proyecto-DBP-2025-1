package com.example.watchapp.Incident.domain;

import org.springframework.context.ApplicationEvent;

public class IncidentCreatedEvent extends ApplicationEvent {
    private final Incident incident;

    public IncidentCreatedEvent(Object source, Incident incident) {
        super(source);
        this.incident = incident;
    }

    public Incident getIncident() {
        return incident;
    }
}

