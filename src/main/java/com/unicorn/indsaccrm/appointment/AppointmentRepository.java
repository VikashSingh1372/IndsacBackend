package com.unicorn.indsaccrm.appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface AppointmentRepository extends JpaRepository<Appointment,UUID> {
}
