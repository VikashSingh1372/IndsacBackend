package com.unicorn.indsaccrm.common.sales.subscribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/subscribe")
public class SubscribeController {

    @Autowired
    private SubscribeService service;

    @PostMapping
    public ResponseEntity<?> saveSubscribe(@RequestBody Subscribe request) throws Exception {
        return ResponseEntity.ok(service.saveSubscribe(request));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEnquiry() throws Exception {
        return ResponseEntity.ok(service.getAllSubscribe());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByEnquiryId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(service.getSubscribeById(id));
    }
}
