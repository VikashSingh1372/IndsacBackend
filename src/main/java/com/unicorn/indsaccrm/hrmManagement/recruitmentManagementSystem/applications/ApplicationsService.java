package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applications;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface ApplicationsService {
    ResponseEntity<?> saveApplications(Applications applications);
    ResponseEntity<List<Applications>> getAllApplicationss();
    ResponseEntity<Optional<Applications>> getApplicationsById(UUID id);
    ResponseEntity<List<Applications>> getApplicationsByJobid(UUID id);
    ResponseEntity<List<Applications>> getApplicationsByApplicantid(UUID id);
    ResponseEntity<List<Applications>> getApplicationsByUsercid(UUID id);
    ResponseEntity<List<Applications>> getApplicationsByUseradminid(UUID id);
}