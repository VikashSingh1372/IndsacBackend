package com.unicorn.indsaccrm.ProjectManagement.ProjectTimeTracing;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TimeTracingRepository extends JpaRepository<TimeTracing, UUID> {
    List<TimeTracing> findByTasksId(UUID tasksId);
    List<TimeTracing> findByUserId(UUID userId);
}

