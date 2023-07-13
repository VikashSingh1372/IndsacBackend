package com.unicorn.indsaccrm.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationServiceImpl implements OrganizationSerive{

    @Autowired
    OrganizationRepository organizationRepository;

    Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);


    @Override
    public ResponseEntity<?> saveOrganization(Organization organization) {
        logger.info("save Organization inside saveOrganization successfully ");
        return ResponseEntity.ok(organizationRepository.save(organization));
    }

    @Override
    public ResponseEntity<List<Organization>> getAllOrganizations() {
        logger.info("GET all Organizations inside getAllOrganizations successfully ");
        return ResponseEntity.ok(organizationRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Organization>> getOrganizationById(UUID id) {
        logger.info("GET Organization By Id inside getOrganizationById successfully ");
        return ResponseEntity.ok(organizationRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<Organization>> getOrganizationByUseradminid(UUID id) {
        logger.info("GET Organization By Useradminid inside getOrganizationByUseradminid successfully ");
        return ResponseEntity.ok(organizationRepository.findByUseradminid(id));
    }

    @Override
    public ResponseEntity<List<Organization>> getOrganizationByUsercid(UUID id) {
        logger.info("GET Organization By Usercid inside getOrganizationByUsercid successfully ");
        return ResponseEntity.ok(organizationRepository.findByUsercid(id));
    }

    @Override
    public ResponseEntity<List<Organization>> getOrganizationByOwneruserid(UUID id) {
        logger.info("GET Organization By Owneruserid inside getOrganizationByOwneruserid successfully ");
        return ResponseEntity.ok(organizationRepository.findByOwneruserid(id));
    }
}
