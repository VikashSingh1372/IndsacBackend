package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationsServiceImpl implements ApplicationsService {
   @Autowired
   ApplicationsRepository applicationsRepository;
   Logger logger = LoggerFactory.getLogger(ApplicationsServiceImpl.class);
   @Override
   public ResponseEntity<?> saveApplications(Applications applications) {
      logger.info("Save Applications from saveApplications Successully");
      return ResponseEntity.ok(applicationsRepository.save(applications));
   }
   @Override
   public ResponseEntity<List<Applications>> getAllApplicationss() {
      logger.info("GET all Applicationss from getAllApplicationss Successully");
      return ResponseEntity.ok(applicationsRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<Applications>> getApplicationsById(UUID id) {
      logger.info("GET Applications By Id from getApplicationsById Successfully");
      return ResponseEntity.ok(applicationsRepository.findById(id));
   }
   @Override
   public ResponseEntity<List<Applications>> getApplicationsByJobid(UUID id) {
      logger.info("GET All Applications By Jobid from getApplicationsByJobid Successfully");
      return ResponseEntity.ok(applicationsRepository.findByJobid(id));
   }
   @Override
   public ResponseEntity<List<Applications>> getApplicationsByApplicantid(UUID id) {
      logger.info("GET All Applications By Applicantid from getApplicationsByApplicantid Successfully");
      return ResponseEntity.ok(applicationsRepository.findByApplicantid(id));
   }
   @Override
   public ResponseEntity<List<Applications>> getApplicationsByUsercid(UUID id) {
      logger.info("GET All Applications By Usercid from getApplicationsByUsercid Successfully");
      return ResponseEntity.ok(applicationsRepository.findByUsercid(id));
   }
   @Override
   public ResponseEntity<List<Applications>> getApplicationsByUseradminid(UUID id) {
      logger.info("GET All Applications By Useradminid from getApplicationsByUseradminid Successfully");
      return ResponseEntity.ok(applicationsRepository.findByUseradminid(id));
   }
}