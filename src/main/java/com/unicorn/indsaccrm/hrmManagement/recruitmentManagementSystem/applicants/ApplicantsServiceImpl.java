package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applicants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicantsServiceImpl implements ApplicantsService {
   @Autowired
   ApplicantsRepository applicantsRepository;
   Logger logger = LoggerFactory.getLogger(ApplicantsServiceImpl.class);
   @Override
   public ResponseEntity<?> saveApplicants(Applicants applicants) {
      logger.info("Save Applicants from saveApplicants Successully");
      return ResponseEntity.ok(applicantsRepository.save(applicants));
   }
   @Override
   public ResponseEntity<List<Applicants>> getAllApplicantss() {
      logger.info("GET all Applicantss from getAllApplicantss Successully");
      return ResponseEntity.ok(applicantsRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<Applicants>> getApplicantsById(UUID id) {
      logger.info("GET Applicants By Id from getApplicantsById Successfully");
      return ResponseEntity.ok(applicantsRepository.findById(id));
   }
   @Override
   public ResponseEntity<List<Applicants>> getApplicantsByJobid(UUID id) {
      logger.info("GET All Applicants By Jobid from getApplicantsByJobid Successfully");
      return ResponseEntity.ok(applicantsRepository.findByJobid(id));
   }
   @Override
   public ResponseEntity<List<Applicants>> getApplicantsByUsercid(UUID id) {
      logger.info("GET All Applicants By Usercid from getApplicantsByUsercid Successfully");
      return ResponseEntity.ok(applicantsRepository.findByUsercid(id));
   }
   @Override
   public ResponseEntity<List<Applicants>> getApplicantsByUseradminid(UUID id) {
      logger.info("GET All Applicants By Useradminid from getApplicantsByUseradminid Successfully");
      return ResponseEntity.ok(applicantsRepository.findByUseradminid(id));   }
}