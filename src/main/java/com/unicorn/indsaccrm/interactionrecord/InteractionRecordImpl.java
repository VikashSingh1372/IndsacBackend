package com.unicorn.indsaccrm.interactionrecord;

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
public class InteractionRecordImpl implements InteractionRecordService{
    @Autowired
    InteractionRecordRepository interactionRecordRepository;

    Logger logger= LoggerFactory.logger(InteractionRecordImpl.class);
    @Override
    public ResponseEntity<?> saveAllInteraction(InteractionRecord request) {
        interactionRecordRepository.save(request);
        return new ResponseEntity<>("save all interaction record successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<InteractionRecord>> getAllInteraction() {
        logger.info("get all data interaction record successfully");
        return ResponseEntity.ok(interactionRecordRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<InteractionRecord>> getByIdInteraction(UUID id) {
        logger.info("interaction record getting by id");
        return ResponseEntity.ok(interactionRecordRepository.findById(id));
    }
}
