package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.interviews;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface InterviewsService {
    ResponseEntity<?> saveInterviews(Interviews interviews);
    ResponseEntity<List<Interviews>> getAllInterviewss();
    ResponseEntity<Optional<Interviews>> getInterviewsById(UUID id);
    ResponseEntity<List<Interviews>> getInterviewsByApplicationid(UUID id);
    ResponseEntity<List<Interviews>> getInterviewsByUsercid(UUID id);
    ResponseEntity<List<Interviews>> getInterviewsByUseradminid(UUID id);
}