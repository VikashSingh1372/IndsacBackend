package com.unicorn.indsaccrm.hrmManagement.onBoarding.documents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentsServiceImpl implements DocumentsService {
   @Autowired
   DocumentsRepository documentsRepository;
   Logger logger = LoggerFactory.getLogger(DocumentsServiceImpl.class);
   @Override
   public ResponseEntity<?> saveDocuments(Documents documents) {
      logger.info("Save Documents from saveDocuments Successully");
      return ResponseEntity.ok(documentsRepository.save(documents));
   }
   @Override
   public ResponseEntity<List<Documents>> getAllDocumentss() {
      logger.info("GET all Documentss from getAllDocumentss Successully");
      return ResponseEntity.ok(documentsRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<Documents>> getDocumentsById(UUID id) {
      logger.info("GET Documents By Id from getDocumentsById Successfully");
      return ResponseEntity.ok(documentsRepository.findById(id));
   }

   @Override
   public ResponseEntity<List<Documents>> getDocumentsByEmployeeid(UUID id) {
      logger.info("GET All Documents By Employeeid from getDocumentsByEmployeeid Successfully");
      return ResponseEntity.ok(documentsRepository.findByEmployeeid(id));
   }

   @Override
   public ResponseEntity<List<Documents>> getDocumentsByUsercid(UUID id) {
      logger.info("GET All Documents By Usercid from getDocumentsByUsercid Successfully");
      return ResponseEntity.ok(documentsRepository.findByUsercid(id));
   }

   @Override
   public ResponseEntity<List<Documents>> getDocumentsByUseradminid(UUID id) {
      logger.info("GET All Documents By Useradminid from getDocumentsByUseradminid Successfully");
      return ResponseEntity.ok(documentsRepository.findByUseradminid(id));
   }
}