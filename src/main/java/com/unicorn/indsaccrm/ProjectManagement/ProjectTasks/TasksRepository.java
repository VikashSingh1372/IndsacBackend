package com.unicorn.indsaccrm.ProjectManagement.ProjectTasks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TasksRepository extends JpaRepository<Tasks, UUID> {
    List<Tasks> findByProjectId(UUID projectId);
    List<Tasks> findByUserId(UUID userId);
}

