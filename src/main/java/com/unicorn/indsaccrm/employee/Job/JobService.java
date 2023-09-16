package com.unicorn.indsaccrm.employee.Job;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JobService {
    ResponseEntity<?> saveJob(Job job);
    ResponseEntity<List<Job>> getAllJobs();
    ResponseEntity<Optional<Job>> getJobById(UUID id);
    ResponseEntity<List<Job>> getJobByUsercid(UUID id);
    ResponseEntity<List<Job>> getJobByUseradminid(UUID id);
}
