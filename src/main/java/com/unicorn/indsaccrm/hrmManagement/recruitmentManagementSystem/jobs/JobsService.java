package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.jobs;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface JobsService {
    ResponseEntity<?> saveJobs(Jobs jobs);
    ResponseEntity<List<Jobs>> getAllJobss();
    ResponseEntity<Optional<Jobs>> getJobsById(UUID id);
    ResponseEntity<List<Jobs>> getJobsByUsercid(UUID id);
    ResponseEntity<List<Jobs>> getJobsByUseradminid(UUID id);
}