package com.unicorn.indsaccrm.ProjectManagement.ProjectMilestones;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MilestonesRepository extends JpaRepository<Milestones, UUID> {
    List<Milestones> findByProjectId(UUID projectId);

}
