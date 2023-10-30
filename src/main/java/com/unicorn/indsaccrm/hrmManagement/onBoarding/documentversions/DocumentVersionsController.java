package com.unicorn.indsaccrm.hrmManagement.onBoarding.documentversions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/documentversions")
public class DocumentVersionsController {
    @Autowired
    private DocumentVersionsService documentVersionsService;
    @PostMapping
    ResponseEntity<?> createDocumentVersions(@RequestBody DocumentVersions documentVersions) throws Exception {
        return ResponseEntity.ok(documentVersionsService.saveDocumentVersions(documentVersions));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllDocumentVersions() throws Exception {
        return ResponseEntity.ok(documentVersionsService.getAllDocumentVersionss());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getDocumentVersionsByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentVersionsService.getDocumentVersionsById(id));
    }
    @GetMapping("/employeeid/{id}")
    ResponseEntity<?> getDocumentVersionsByEmployeeid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentVersionsService.getDocumentVersionsByEmployeeid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getDocumentVersionsByUsercid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentVersionsService.getDocumentVersionsByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getDocumentVersionsByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentVersionsService.getDocumentVersionsByUseradminid(id));
    }
}