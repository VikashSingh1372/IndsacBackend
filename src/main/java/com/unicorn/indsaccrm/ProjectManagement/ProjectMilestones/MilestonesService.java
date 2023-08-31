package com.unicorn.indsaccrm.ProjectManagement.ProjectMilestones;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MilestonesService {

    ResponseEntity<?> saveMilestones(Milestones milestones);

    ResponseEntity<List<Milestones>> getAllMilestones();

    ResponseEntity<Optional<Milestones>> getMilestonesById(UUID id);

    ResponseEntity<List<Milestones>> getMilestonesByProjectId(UUID id);

}
