package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applicants;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface ApplicantsService {
    ResponseEntity<?> saveApplicants(Applicants applicants);
    ResponseEntity<List<Applicants>> getAllApplicantss();
    ResponseEntity<Optional<Applicants>> getApplicantsById(UUID id);
    ResponseEntity<List<Applicants>> getApplicantsByJobid(UUID id);
    ResponseEntity<List<Applicants>> getApplicantsByUsercid(UUID id);
    ResponseEntity<List<Applicants>> getApplicantsByUseradminid(UUID id);
}