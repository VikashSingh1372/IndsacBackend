package com.unicorn.indsaccrm.appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @PostMapping
    ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) throws Exception {
        return ResponseEntity.ok(appointmentService.saveAppointment(appointment));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllAppointment() throws Exception {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getAppointmentByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }
}