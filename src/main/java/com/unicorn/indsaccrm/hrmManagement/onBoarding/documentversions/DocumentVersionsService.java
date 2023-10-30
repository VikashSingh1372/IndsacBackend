package com.unicorn.indsaccrm.hrmManagement.onBoarding.documentversions;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface DocumentVersionsService {
    ResponseEntity<?> saveDocumentVersions(DocumentVersions documentVersions);
    ResponseEntity<List<DocumentVersions>> getAllDocumentVersionss();
    ResponseEntity<Optional<DocumentVersions>> getDocumentVersionsById(UUID id);
    ResponseEntity<List<DocumentVersions>> getDocumentVersionsByEmployeeid(UUID id);
    ResponseEntity<List<DocumentVersions>> getDocumentVersionsByUsercid(UUID id);
    ResponseEntity<List<DocumentVersions>> getDocumentVersionsByUseradminid(UUID id);
}