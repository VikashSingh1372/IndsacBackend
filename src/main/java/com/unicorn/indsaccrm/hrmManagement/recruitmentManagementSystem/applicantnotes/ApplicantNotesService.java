package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applicantnotes;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface ApplicantNotesService {
    ResponseEntity<?> saveApplicantNotes(ApplicantNotes applicantNotes);
    ResponseEntity<List<ApplicantNotes>> getAllApplicantNotess();
    ResponseEntity<Optional<ApplicantNotes>> getApplicantNotesById(UUID id);
    ResponseEntity<List<ApplicantNotes>> getApplicantNotesByApplicationid(UUID id);
    ResponseEntity<List<ApplicantNotes>> getApplicantNotesByUsercid(UUID id);
    ResponseEntity<List<ApplicantNotes>> getApplicantNotesByUseradminid(UUID id);
}