package com.unicorn.indsaccrm.employee.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobService jobService;
    @PostMapping
    ResponseEntity<?> saveJob(@RequestBody Job job){
        return ResponseEntity.ok(jobService.saveJob(job));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllJobs()throws Exception {
        return ResponseEntity.ok(jobService.getAllJobs());
    }
    //primary key
    @GetMapping("/{id}")
    ResponseEntity<?> getJobById(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(jobService.getJobById(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getJobByUsercid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(jobService.getJobByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getJobByUseradminid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(jobService.getJobByUseradminid(id));
    }
}
