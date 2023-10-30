package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.interviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/interviews")
public class InterviewsController {
    @Autowired
    private InterviewsService interviewsService;
    @PostMapping
    ResponseEntity<?> createInterviews(@RequestBody Interviews interviews) throws Exception {
        return ResponseEntity.ok(interviewsService.saveInterviews(interviews));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllInterviews() throws Exception {
        return ResponseEntity.ok(interviewsService.getAllInterviewss());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getInterviewsByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(interviewsService.getInterviewsById(id));
    }
    @GetMapping("/applicationid/{id}")
    ResponseEntity<?> getInterviewsByApplicationid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(interviewsService.getInterviewsByApplicationid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getInterviewsByUsercid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(interviewsService.getInterviewsByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getInterviewsByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(interviewsService.getInterviewsByUseradminid(id));
    }
}