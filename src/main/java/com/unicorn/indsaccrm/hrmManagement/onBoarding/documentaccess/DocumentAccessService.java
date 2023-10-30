package com.unicorn.indsaccrm.hrmManagement.onBoarding.documentaccess;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface DocumentAccessService {
    ResponseEntity<?> saveDocumentAccess(DocumentAccess documentAccess);
    ResponseEntity<List<DocumentAccess>> getAllDocumentAccesss();
    ResponseEntity<Optional<DocumentAccess>> getDocumentAccessById(UUID id);
    ResponseEntity<List<DocumentAccess>> getDocumentAcccessByEmployeeid(UUID id);
    ResponseEntity<List<DocumentAccess>> getDocumentAcccessByDocumentid(UUID id);
    ResponseEntity<List<DocumentAccess>> getDocumentAcccessByUsercid(UUID id);
    ResponseEntity<List<DocumentAccess>> getDocumentAcccessByUseradminid(UUID id);
}