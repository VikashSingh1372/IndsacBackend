package com.unicorn.indsaccrm.common.user.profile;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfileService {
    ResponseEntity<?> saveprofile(Profile requestuserprofile);
    ResponseEntity<List<Profile>>getAllProfiles();
    ResponseEntity<Optional<Profile>>getByProfileId(UUID id);
    ResponseEntity <List<Profile>>getByProfileUserId(UUID userId);
}
