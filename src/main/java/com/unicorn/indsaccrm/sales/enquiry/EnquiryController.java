package com.unicorn.indsaccrm.sales.enquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
    @Autowired
    private EnquiryService service;
    @Autowired
    private EnquiryRepository enquiryRepository;

    @PostMapping
    public ResponseEntity<?> saveEnquiry(@RequestBody Enquiry request) throws Exception {
        return ResponseEntity.ok(service.saveEnquiry(request));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEnquiry() throws Exception {
        return ResponseEntity.ok(service.getAllEnquiry());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByEnquiryId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(enquiryRepository.findById(id));
    }
}
