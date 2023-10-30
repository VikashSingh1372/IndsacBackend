package com.unicorn.indsaccrm.hrmManagement.onBoarding.documentversions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentVersionsServiceImpl implements DocumentVersionsService {
   @Autowired
   DocumentVersionsRepository documentVersionsRepository;
   Logger logger = LoggerFactory.getLogger(DocumentVersionsServiceImpl.class);
   @Override
   public ResponseEntity<?> saveDocumentVersions(DocumentVersions documentVersions) {
      logger.info("Save DocumentVersions from saveDocumentVersions Successully");
      return ResponseEntity.ok(documentVersionsRepository.save(documentVersions));
   }
   @Override
   public ResponseEntity<List<DocumentVersions>> getAllDocumentVersionss() {
      logger.info("GET all DocumentVersionss from getAllDocumentVersionss Successully");
      return ResponseEntity.ok(documentVersionsRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<DocumentVersions>> getDocumentVersionsById(UUID id) {
      logger.info("GET DocumentVersions By Id from getDocumentVersionsById Successfully");
      return ResponseEntity.ok(documentVersionsRepository.findById(id));
   }
   @Override
   public ResponseEntity<List<DocumentVersions>> getDocumentVersionsByEmployeeid(UUID id) {
      logger.info("GET All DocumentVersions By Employeeid from getDocumentVersionsByEmployeeid Successfully");
      return ResponseEntity.ok(documentVersionsRepository.findByEmployeeid(id));
   }
   @Override
   public ResponseEntity<List<DocumentVersions>> getDocumentVersionsByUsercid(UUID id) {
      logger.info("GET All DocumentVersions By Usercid from getDocumentVersionsByUsercid Successfully");
      return ResponseEntity.ok(documentVersionsRepository.findByUsercid(id));
   }
   @Override
   public ResponseEntity<List<DocumentVersions>> getDocumentVersionsByUseradminid(UUID id) {
      logger.info("GET All DocumentVersions By Useradminid from getDocumentVersionsByUseradminid Successfully");
      return ResponseEntity.ok(documentVersionsRepository.findByUseradminid(id));
   }
}