package com.unicorn.indsaccrm.ProjectManagement.ProjectTasks;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectTasksService {
    ResponseEntity<?> saveTasks(ProjectTasks tasks);
    ResponseEntity<List<ProjectTasks>> getTasks();
    ResponseEntity<Optional<ProjectTasks>> getTasksById(UUID id);
    ResponseEntity<List<ProjectTasks>> getTasksByProjectId(UUID id);
    ResponseEntity<List<ProjectTasks>> getTasksByUserId(UUID id);
}

