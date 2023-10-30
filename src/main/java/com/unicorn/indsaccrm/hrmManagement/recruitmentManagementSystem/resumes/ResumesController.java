package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.resumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/resumes")
public class ResumesController {
    @Autowired
    private ResumesService resumesService;
    @PostMapping
    ResponseEntity<?> createResumes(@RequestBody Resumes resumes) throws Exception {
        return ResponseEntity.ok(resumesService.saveResumes(resumes));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllResumes() throws Exception {
        return ResponseEntity.ok(resumesService.getAllResumess());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getResumesByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(resumesService.getResumesById(id));
    }
    @GetMapping("/applicantid/{id}")
    ResponseEntity<?> getResumesByApplicationid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(resumesService.getResumesByApplicantid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getResumesByUsercid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(resumesService.getResumesByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getResumesByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(resumesService.getResumesByUseradminid(id));
    }
}