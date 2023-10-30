package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applicants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/applicants")
public class ApplicantsController {
    @Autowired
    private ApplicantsService applicantsService;
    @PostMapping
    ResponseEntity<?> createApplicants(@RequestBody Applicants applicants) throws Exception {
        return ResponseEntity.ok(applicantsService.saveApplicants(applicants));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllApplicants() throws Exception {
        return ResponseEntity.ok(applicantsService.getAllApplicantss());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getApplicantsByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicantsService.getApplicantsById(id));
    }
    @GetMapping("/jobid/{id}")
    ResponseEntity<?> getApplicantsByJobid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicantsService.getApplicantsByJobid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getApplicantsByUsercid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicantsService.getApplicantsByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getApplicantsByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicantsService.getApplicantsByUseradminid(id));
    }
}