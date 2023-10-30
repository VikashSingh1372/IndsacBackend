package com.unicorn.indsaccrm.hrmManagement.onBoarding.documents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/documents")
public class DocumentsController {
    @Autowired
    private DocumentsService documentsService;
    @PostMapping
    ResponseEntity<?> createDocuments(@RequestBody Documents documents) throws Exception {
        return ResponseEntity.ok(documentsService.saveDocuments(documents));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllDocuments() throws Exception {
        return ResponseEntity.ok(documentsService.getAllDocumentss());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getDocumentsByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentsService.getDocumentsById(id));
    }
    @GetMapping("/employeeid/{id}")
    ResponseEntity<?> getDocumentsByEmployeeid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentsService.getDocumentsByEmployeeid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getDocumentsByUsercid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentsService.getDocumentsByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getDocumentsByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentsService.getDocumentsByUseradminid(id));
    }
}