package com.unicorn.indsaccrm.hrmManagement.onBoarding.documentaccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentAccessServiceImpl implements DocumentAccessService {
   @Autowired
   DocumentAccessRepository documentAccessRepository;
   Logger logger = LoggerFactory.getLogger(DocumentAccessServiceImpl.class);
   @Override
   public ResponseEntity<?> saveDocumentAccess(DocumentAccess documentAccess) {
      logger.info("Save DocumentAccess from saveDocumentAccess Successully");
      return ResponseEntity.ok(documentAccessRepository.save(documentAccess));
   }
   @Override
   public ResponseEntity<List<DocumentAccess>> getAllDocumentAccesss() {
      logger.info("GET all DocumentAccesss from getAllDocumentAccesss Successully");
      return ResponseEntity.ok(documentAccessRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<DocumentAccess>> getDocumentAccessById(UUID id) {
      logger.info("GET DocumentAccess By Id from getDocumentAccessById Successfully");
      return ResponseEntity.ok(documentAccessRepository.findById(id));
   }
   @Override
   public ResponseEntity<List<DocumentAccess>> getDocumentAcccessByEmployeeid(UUID id) {
      logger.info("GET All DocumentAccess By Employeeid from getDocumentAccessByEmployeeid Successfully");
      return ResponseEntity.ok(documentAccessRepository.findByEmployeeid(id));
   }
   @Override
   public ResponseEntity<List<DocumentAccess>> getDocumentAcccessByDocumentid(UUID id) {
      logger.info("GET All DocumentAccess By Documentid from getDocumentAccessByDocumentid Successfully");
      return ResponseEntity.ok(documentAccessRepository.findByDocumentid(id));
   }
   @Override
   public ResponseEntity<List<DocumentAccess>> getDocumentAcccessByUsercid(UUID id) {
      logger.info("GET All DocumentAccess By Usercid from getDocumentAccessByUsercid Successfully");
      return ResponseEntity.ok(documentAccessRepository.findByUsercid(id));
   }
   @Override
   public ResponseEntity<List<DocumentAccess>> getDocumentAcccessByUseradminid(UUID id) {
      logger.info("GET All DocumentAccess By Useradminid from getDocumentAccessByUseradminid Successfully");
      return ResponseEntity.ok(documentAccessRepository.findByUseradminid(id));
   }
}