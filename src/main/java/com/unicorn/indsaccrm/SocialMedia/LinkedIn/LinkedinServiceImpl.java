package com.unicorn.indsaccrm.SocialMedia.LinkedIn;

import com.unicorn.indsaccrm.organization.OrganizationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LinkedinServiceImpl implements LinkedInService{

    @Autowired
    private LinkedinRepository linkedinRepository;

    Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    @Override
    public ResponseEntity<?> saveLinkedIn(LinkedIn linkedIn) {
        logger.info("save LinkedIn inside saveLinkedIn successfully ");
        return ResponseEntity.ok(linkedinRepository.save(linkedIn));
    }

    @Override
    public ResponseEntity<List<LinkedIn>> getAllLinkedIns() {
        logger.info("GET all LinkedIns inside getAllLinkedIns successfully ");
        return ResponseEntity.ok(linkedinRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<LinkedIn>> getLinkedInById(UUID id) {
        logger.info("GET LinkedIn by Id inside getLinkedInById successfully ");
        return ResponseEntity.ok(linkedinRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<LinkedIn>> getLinkedInByUserid(UUID userid) {
        logger.info("GET LinkedIn by Userid inside getLinkedInByUserid successfully ");
        return ResponseEntity.ok(linkedinRepository.findByUserid(userid));
    }

    @Override
    public ResponseEntity<List<LinkedIn>> getLinkedInByOrgid(UUID orgid) {
        logger.info("GET LinkedIn by Orgid inside getLinkedInByOrgid successfully ");
        return ResponseEntity.ok(linkedinRepository.findByOrgid(orgid));
    }
}
