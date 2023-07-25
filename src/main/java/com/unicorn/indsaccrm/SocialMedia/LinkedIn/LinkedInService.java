package com.unicorn.indsaccrm.SocialMedia.LinkedIn;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LinkedInService {
    ResponseEntity<?> saveLinkedIn(LinkedIn linkedIn);

    ResponseEntity<List<LinkedIn>> getAllLinkedIns();

    ResponseEntity<Optional<LinkedIn>> getLinkedInById(UUID id);

    ResponseEntity<List<LinkedIn>> getLinkedInByUserid(UUID userid);

    ResponseEntity<List<LinkedIn>> getLinkedInByOrgid(UUID orgid);
}
