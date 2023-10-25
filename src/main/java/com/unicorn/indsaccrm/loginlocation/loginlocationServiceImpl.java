package com.unicorn.indsaccrm.loginlocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class loginlocationServiceImpl implements loginlocationService {
   @Autowired
   loginlocationRepository loginlocationRepository;
   Logger logger = LoggerFactory.getLogger(loginlocationServiceImpl.class);
   @Override
   public ResponseEntity<?> saveloginlocation(loginlocation loginlocation) {
      logger.info("Save loginlocation from saveloginlocation Successully");
      return ResponseEntity.ok(loginlocationRepository.save(loginlocation));
   }
   @Override
   public ResponseEntity<List<loginlocation>> getAllloginlocations() {
      logger.info("GET all loginlocations from getAllloginlocations Successully");
      return ResponseEntity.ok(loginlocationRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<loginlocation>> getloginlocationById(UUID id) {
      logger.info("GET loginlocation By Id from getloginlocationById Successfully");
      return ResponseEntity.ok(loginlocationRepository.findById(id));
   }
}