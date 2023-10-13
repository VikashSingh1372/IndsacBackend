package com.unicorn.indsaccrm.appointment;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface AppointmentService {
    ResponseEntity<?> saveAppointment(Appointment appointment);
    ResponseEntity<List<Appointment>> getAllAppointments();
    ResponseEntity<Optional<Appointment>> getAppointmentById(UUID id);
}