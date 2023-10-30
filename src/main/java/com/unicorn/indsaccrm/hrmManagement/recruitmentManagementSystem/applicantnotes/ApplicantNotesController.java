package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applicantnotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/applicantnotes")
public class ApplicantNotesController {
    @Autowired
    private ApplicantNotesService applicantNotesService;
    @PostMapping
    ResponseEntity<?> createApplicantNotes(@RequestBody ApplicantNotes applicantNotes) throws Exception {
        return ResponseEntity.ok(applicantNotesService.saveApplicantNotes(applicantNotes));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllApplicantNotes() throws Exception {
        return ResponseEntity.ok(applicantNotesService.getAllApplicantNotess());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getApplicantNotesByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicantNotesService.getApplicantNotesById(id));
    }
    @GetMapping("/applicationid/{id}")
    ResponseEntity<?> getApplicantNotesByApplicationid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicantNotesService.getApplicantNotesByApplicationid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getApplicantNotesByUsercid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicantNotesService.getApplicantNotesByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getApplicantNotesByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(applicantNotesService.getApplicantNotesByUseradminid(id));
    }
}