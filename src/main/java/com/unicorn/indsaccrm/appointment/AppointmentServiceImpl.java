package com.unicorn.indsaccrm.appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class AppointmentServiceImpl implements AppointmentService {
   @Autowired
   AppointmentRepository appointmentRepository;
   Logger logger = LoggerFactory.getLogger(AppointmentServiceImpl.class);
   @Override
   public ResponseEntity<?> saveAppointment(Appointment appointment) {
      logger.info("Save Appointment from saveAppointment Successully");
      return ResponseEntity.ok(appointmentRepository.save(appointment));
   }
   @Override
   public ResponseEntity<List<Appointment>> getAllAppointments() {
      logger.info("GET all Appointments from getAllAppointments Successully");
      return ResponseEntity.ok(appointmentRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<Appointment>> getAppointmentById(UUID id) {
      logger.info("GET Appointment By Id from getAppointmentById Successfully");
      return ResponseEntity.ok(appointmentRepository.findById(id));
   }
}