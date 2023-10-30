package com.unicorn.indsaccrm.hrmManagement.onBoarding.documents;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface DocumentsService {
    ResponseEntity<?> saveDocuments(Documents documents);
    ResponseEntity<List<Documents>> getAllDocumentss();
    ResponseEntity<Optional<Documents>> getDocumentsById(UUID id);
    ResponseEntity<List<Documents>> getDocumentsByEmployeeid(UUID id);
    ResponseEntity<List<Documents>> getDocumentsByUsercid(UUID id);
    ResponseEntity<List<Documents>> getDocumentsByUseradminid(UUID id);
}