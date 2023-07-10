package com.unicorn.indsaccrm.common.user.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
  ProfileService profileService;
    @PostMapping
    ResponseEntity<?> createAuthenticationToken(@RequestBody Profile profile) throws Exception {
        return ResponseEntity.ok(profileService.saveprofile(profile));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllProfile() throws Exception {
        return ResponseEntity.ok(profileService.getAllProfiles());
    }
    @GetMapping("{id}")
    ResponseEntity<?> getByProfileId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(profileService.getByProfileId(id));
    }

    @GetMapping("/user/{userid}")
    ResponseEntity<?> getByUserId(@PathVariable UUID userid) throws Exception {
        List<Profile> list = profileService.getByProfileUserId(userid).getBody();
        if (list != null && !list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
