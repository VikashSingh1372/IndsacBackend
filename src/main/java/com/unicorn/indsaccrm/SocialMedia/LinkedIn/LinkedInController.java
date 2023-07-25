package com.unicorn.indsaccrm.SocialMedia.LinkedIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/linkedin")
public class LinkedInController {

    @Autowired
    private LinkedInService linkedInService;

    @PostMapping
    ResponseEntity<?> saveLinkedin(@RequestBody LinkedIn linkedIn)throws Exception{
        return ResponseEntity.ok(linkedInService.saveLinkedIn(linkedIn));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllLinkedIns()throws Exception{
        return ResponseEntity.ok(linkedInService.getAllLinkedIns());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getLinkedInByID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(linkedInService.getLinkedInById(id));
    }

    @GetMapping("/userid/{userid}")
    ResponseEntity<?> getLinkedInByUserid(@PathVariable UUID userid)throws Exception {
        return ResponseEntity.ok(linkedInService.getLinkedInByUserid(userid));
    }

    @GetMapping("/orgid/{orgid}")
    ResponseEntity<?> getLinkedInByOrgid(@PathVariable UUID orgid)throws Exception {
        return ResponseEntity.ok(linkedInService.getLinkedInByOrgid(orgid));
    }
}
