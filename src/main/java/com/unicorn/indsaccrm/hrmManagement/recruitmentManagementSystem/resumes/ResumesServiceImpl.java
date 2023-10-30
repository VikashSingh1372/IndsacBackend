package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.resumes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ResumesServiceImpl implements ResumesService {
   @Autowired
   ResumesRepository resumesRepository;
   Logger logger = LoggerFactory.getLogger(ResumesServiceImpl.class);
   @Override
   public ResponseEntity<?> saveResumes(Resumes resumes) {
      logger.info("Save Resumes from saveResumes Successully");
      return ResponseEntity.ok(resumesRepository.save(resumes));
   }
   @Override
   public ResponseEntity<List<Resumes>> getAllResumess() {
      logger.info("GET all Resumess from getAllResumess Successully");
      return ResponseEntity.ok(resumesRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<Resumes>> getResumesById(UUID id) {
      logger.info("GET Resumes By Id from getResumesById Successfully");
      return ResponseEntity.ok(resumesRepository.findById(id));
   }

   @Override
   public ResponseEntity<List<Resumes>> getResumesByApplicantid(UUID id) {
      logger.info("GET Resumes By Applicantid from getResumesByApplicantid Successfully");
      return ResponseEntity.ok(resumesRepository.findByApplicantid(id));
   }

   @Override
   public ResponseEntity<List<Resumes>> getResumesByUsercid(UUID id) {
      logger.info("GET Resumes By Usercid from getResumesByUsercid Successfully");
      return ResponseEntity.ok(resumesRepository.findByUsercid(id));
   }

   @Override
   public ResponseEntity<List<Resumes>> getResumesByUseradminid(UUID id) {
      logger.info("GET Resumes By Useradminid from getResumesByUseradminid Successfully");
      return ResponseEntity.ok(resumesRepository.findByUseradminid(id));
   }
}