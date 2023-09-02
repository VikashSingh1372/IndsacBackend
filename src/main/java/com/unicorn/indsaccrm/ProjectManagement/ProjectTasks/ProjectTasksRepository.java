package com.unicorn.indsaccrm.ProjectManagement.ProjectTasks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProjectTasksRepository extends JpaRepository<ProjectTasks, UUID> {
    List<ProjectTasks> findByProjectId(UUID projectId);
    List<ProjectTasks> findByUserId(UUID userId);
}

