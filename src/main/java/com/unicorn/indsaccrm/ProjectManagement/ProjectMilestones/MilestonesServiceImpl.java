package com.unicorn.indsaccrm.ProjectManagement.ProjectMilestones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MilestonesServiceImpl implements MilestonesService{

    @Autowired
    MilestonesRepository milestonesRepository;

    Logger logger = LoggerFactory.getLogger(MilestonesServiceImpl.class);

    @Override
    public ResponseEntity<?> saveMilestones(Milestones milestones) {
        logger.info("Save Milestones from saveMilestones Successully");
        return ResponseEntity.ok(milestonesRepository.save(milestones));
    }

    @Override
    public ResponseEntity<List<Milestones>> getAllMilestones() {
        logger.info("Get all Milestones from getAllMilestones Successully");
        return ResponseEntity.ok(milestonesRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Milestones>> getMilestonesById(UUID id) {
        logger.info("Get Milestones by id from getMilestonesById Successully");
        return ResponseEntity.ok(milestonesRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<Milestones>> getMilestonesByProjectId(UUID id) {
        logger.info("Get Milestones by projectid from getMilestonesByProjectId Successully");
        return ResponseEntity.ok(milestonesRepository.findByProjectId(id));
    }

}
