package com.unicorn.indsaccrm.common.user.usereducation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/usereducation")
public class UserEducationController {
    Logger logger = LoggerFactory.getLogger(UserEducationController.class);
    @Autowired
    UserEducationService userEducationService;

    @PostMapping
    public ResponseEntity<?> saveUserEducation(@RequestBody UserEducation request) throws Exception {
        return ResponseEntity.ok(userEducationService.saveUserEducation(request));
    }

    @GetMapping("/all/{userid}")
    public ResponseEntity<?> getAllUserEducation(@PathVariable UUID userid) throws Exception {
        return ResponseEntity.ok(userEducationService.getAllUserEducationByUser(userid));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userEducationService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByUserEducationId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(userEducationService.getByUserEducationId(id));
    }

}
