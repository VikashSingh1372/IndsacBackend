package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.interviews;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InterviewsServiceImpl implements InterviewsService {
   @Autowired
   InterviewsRepository interviewsRepository;
   Logger logger = LoggerFactory.getLogger(InterviewsServiceImpl.class);
   @Override
   public ResponseEntity<?> saveInterviews(Interviews interviews) {
      logger.info("Save Interviews from saveInterviews Successully");
      return ResponseEntity.ok(interviewsRepository.save(interviews));
   }
   @Override
   public ResponseEntity<List<Interviews>> getAllInterviewss() {
      logger.info("GET all Interviewss from getAllInterviewss Successully");
      return ResponseEntity.ok(interviewsRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<Interviews>> getInterviewsById(UUID id) {
      logger.info("GET Interviews By Id from getInterviewsById Successfully");
      return ResponseEntity.ok(interviewsRepository.findById(id));
   }
   @Override
   public ResponseEntity<List<Interviews>> getInterviewsByApplicationid(UUID id) {
      logger.info("GET All Interviews By Applicationid from getInterviewsByApplicationid Successfully");
      return ResponseEntity.ok(interviewsRepository.findByApplicationid(id));
   }
   @Override
   public ResponseEntity<List<Interviews>> getInterviewsByUsercid(UUID id) {
      logger.info("GET All Interviews By Usercid from getInterviewsByUsercid Successfully");
      return ResponseEntity.ok(interviewsRepository.findByUsercid(id));
   }
   @Override
   public ResponseEntity<List<Interviews>> getInterviewsByUseradminid(UUID id) {
      logger.info("GET All Interviews By Useradminid from getInterviewsByUseradminid Successfully");
      return ResponseEntity.ok(interviewsRepository.findByUseradminid(id));
   }
}