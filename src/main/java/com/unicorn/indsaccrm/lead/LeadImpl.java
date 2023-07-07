package com.unicorn.indsaccrm.lead;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class LeadImpl implements LeadService{
    @Autowired
    LeadRepository leadRepository;

    Logger logger= LoggerFactory.logger(LeadImpl.class);
    @Override
    public ResponseEntity<?> SaveAllLead(Lead lead) {
        leadRepository.save(lead);
        return new ResponseEntity<>("save all lead successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Lead>> getAllLead() {
        logger.info("get all lead successfully");
        return ResponseEntity.ok(leadRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Lead>> getByIdLead(UUID id) {
        logger.info("get lead by id successfully");
        return ResponseEntity.ok(leadRepository.findById(id));
    }
}
