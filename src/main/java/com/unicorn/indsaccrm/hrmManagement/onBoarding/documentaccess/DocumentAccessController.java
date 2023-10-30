package com.unicorn.indsaccrm.hrmManagement.onBoarding.documentaccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/documentaccess")
public class DocumentAccessController {
    @Autowired
    private DocumentAccessService documentAccessService;
    @PostMapping
    ResponseEntity<?> createDocumentAccess(@RequestBody DocumentAccess documentAccess) throws Exception {
        return ResponseEntity.ok(documentAccessService.saveDocumentAccess(documentAccess));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllDocumentAccess() throws Exception {
        return ResponseEntity.ok(documentAccessService.getAllDocumentAccesss());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getDocumentAccessByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentAccessService.getDocumentAccessById(id));
    }
    @GetMapping("/employeeid/{id}")
    ResponseEntity<?> getDocumentAcccessByEmployeeid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentAccessService.getDocumentAcccessByEmployeeid(id));
    }
    @GetMapping("/documentid/{id}")
    ResponseEntity<?> getDocumentAcccessByDocumentid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentAccessService.getDocumentAcccessByDocumentid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getDocumentAcccessByUsercid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentAccessService.getDocumentAcccessByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getDocumentAcccessByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(documentAccessService.getDocumentAcccessByUseradminid(id));
    }
}