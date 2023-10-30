package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.resumes;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface ResumesService {
    ResponseEntity<?> saveResumes(Resumes resumes);
    ResponseEntity<List<Resumes>> getAllResumess();
    ResponseEntity<Optional<Resumes>> getResumesById(UUID id);
    ResponseEntity<List<Resumes>> getResumesByApplicantid(UUID id);
    ResponseEntity<List<Resumes>> getResumesByUsercid(UUID id);
    ResponseEntity<List<Resumes>> getResumesByUseradminid(UUID id);
}