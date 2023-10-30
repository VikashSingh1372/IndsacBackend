package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/jobs")
public class JobsController {
    @Autowired
    private JobsService jobsService;
    @PostMapping
    ResponseEntity<?> createJobs(@RequestBody Jobs jobs) throws Exception {
        return ResponseEntity.ok(jobsService.saveJobs(jobs));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllJobs() throws Exception {
        return ResponseEntity.ok(jobsService.getAllJobss());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getJobsByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(jobsService.getJobsById(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getJobsByUsercid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(jobsService.getJobsByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getJobsByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(jobsService.getJobsByUseradminid(id));
    }
}