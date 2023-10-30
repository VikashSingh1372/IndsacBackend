package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applicantnotes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicantNotesServiceImpl implements ApplicantNotesService {
   @Autowired
   ApplicantNotesRepository applicantNotesRepository;
   Logger logger = LoggerFactory.getLogger(ApplicantNotesServiceImpl.class);
   @Override
   public ResponseEntity<?> saveApplicantNotes(ApplicantNotes applicantNotes) {
      logger.info("Save ApplicantNotes from saveApplicantNotes Successully");
      return ResponseEntity.ok(applicantNotesRepository.save(applicantNotes));
   }
   @Override
   public ResponseEntity<List<ApplicantNotes>> getAllApplicantNotess() {
      logger.info("GET all ApplicantNotess from getAllApplicantNotess Successully");
      return ResponseEntity.ok(applicantNotesRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<ApplicantNotes>> getApplicantNotesById(UUID id) {
      logger.info("GET ApplicantNotes By Id from getApplicantNotesById Successfully");
      return ResponseEntity.ok(applicantNotesRepository.findById(id));
   }

   @Override
   public ResponseEntity<List<ApplicantNotes>> getApplicantNotesByApplicationid(UUID id) {
      logger.info("GET All ApplicantNotes By Applicationid from getApplicantNotesByApplicationid Successfully");
      return ResponseEntity.ok(applicantNotesRepository.findByApplicationid(id));
   }

   @Override
   public ResponseEntity<List<ApplicantNotes>> getApplicantNotesByUsercid(UUID id) {
      logger.info("GET All ApplicantNotes By Usercid from getApplicantNotesByUsercid Successfully");
      return ResponseEntity.ok(applicantNotesRepository.findByUsercid(id));
   }

   @Override
   public ResponseEntity<List<ApplicantNotes>> getApplicantNotesByUseradminid(UUID id) {
      logger.info("GET All ApplicantNotes By Useradminid from getApplicantNotesByUseradminid Successfully");
      return ResponseEntity.ok(applicantNotesRepository.findByUseradminid(id));
   }
}