package com.example.watchapp.Notification.application;
import com.example.watchapp.Incident.domain.Incident;
import com.example.watchapp.Incident.domain.IncidentCreatedEvent;
import com.example.watchapp.Notification.infrastructure.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @Autowired
    private EmailService emailService;

    @Async
    @EventListener
    public void handleIncidentCreated(IncidentCreatedEvent event) {
        Incident incident = event.getIncident();

        // Aquí podrías obtener datos del incidente (como el correo del usuario)
        String to = "destinatario@correo.com"; // ⚠️ reemplazar con incident.getUser().getEmail() si tienes relación
        String subject = "Nuevo incidente registrado";
        String body = "Se ha creado un nuevo incidente con ID: " + incident.getId();

        emailService.sendEmail(to, subject, body);
    }
}
