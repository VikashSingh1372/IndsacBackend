package com.unicorn.indsaccrm.appointment.publicappointmentinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/publicAppointmentInfo")
public class PublicAppointmentInfoController {
    @Autowired
    private PublicAppointmentInfoService publicAppointmentInfoService;
    @PostMapping
    ResponseEntity<?> createPublicAppointmentInfo(@RequestBody PublicAppointmentInfo publicappointmentinfo) throws Exception {
        return ResponseEntity.ok(publicAppointmentInfoService.savePublicAppointmentInfo(publicappointmentinfo));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllPublicAppointmentInfo() throws Exception {
        return ResponseEntity.ok(publicAppointmentInfoService.getAllPublicAppointmentInfos());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getPublicAppointmentInfoByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(publicAppointmentInfoService.getPublicAppointmentInfoById(id));
    }
}