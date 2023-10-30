package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/applications")
public class ApplicationsController {
    @Autowired
    private ApplicationsService applicationsService;
    @PostMapping
    ResponseEntity<?> createApplications(@RequestBody Applications applications) throws Exception {
        return ResponseEntity.ok(applicationsService.saveApplications(applications));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllApplications() throws Exception {
        return ResponseEntity.ok(applicationsService.getAllApplicationss());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getApplicationsByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicationsService.getApplicationsById(id));
    }
    @GetMapping("/jobid/{id}")
    ResponseEntity<?> getApplicationsByJobid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicationsService.getApplicationsByJobid(id));
    }
    @GetMapping("/applicantid/{id}")
    ResponseEntity<?> getApplicationsByApplicantid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicationsService.getApplicationsByApplicantid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getApplicationsByUsercid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicationsService.getApplicationsByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getApplicationsByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicationsService.getApplicationsByUseradminid(id));
    }
}