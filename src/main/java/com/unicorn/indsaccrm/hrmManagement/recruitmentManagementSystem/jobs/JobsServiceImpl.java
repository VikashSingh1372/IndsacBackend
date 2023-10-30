package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.jobs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobsServiceImpl implements JobsService {
   @Autowired
   JobsRepository jobsRepository;
   Logger logger = LoggerFactory.getLogger(JobsServiceImpl.class);
   @Override
   public ResponseEntity<?> saveJobs(Jobs jobs) {
      logger.info("Save Jobs from saveJobs Successully");
      return ResponseEntity.ok(jobsRepository.save(jobs));
   }
   @Override
   public ResponseEntity<List<Jobs>> getAllJobss() {
      logger.info("GET all Jobss from getAllJobss Successully");
      return ResponseEntity.ok(jobsRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<Jobs>> getJobsById(UUID id) {
      logger.info("GET Jobs By Id from getJobsById Successfully");
      return ResponseEntity.ok(jobsRepository.findById(id));
   }
   @Override
   public ResponseEntity<List<Jobs>> getJobsByUsercid(UUID id) {
      logger.info("GET Jobs By Usercid from getJobsByUsercid Successfully");
      return ResponseEntity.ok(jobsRepository.findByUsercid(id));
   }
   @Override
   public ResponseEntity<List<Jobs>> getJobsByUseradminid(UUID id) {
      logger.info("GET Jobs By Useradminid from getJobsByUseradminid Successfully");
      return ResponseEntity.ok(jobsRepository.findByUseradminid(id));
   }
}