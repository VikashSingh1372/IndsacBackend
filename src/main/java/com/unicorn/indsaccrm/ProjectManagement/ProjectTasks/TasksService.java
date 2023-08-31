package com.unicorn.indsaccrm.ProjectManagement.ProjectTasks;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TasksService {
    ResponseEntity<?> saveTasks(Tasks tasks);
    ResponseEntity<List<Tasks>> getTasks();
    ResponseEntity<Optional<Tasks>> getTasksById(UUID id);
    ResponseEntity<List<Tasks>> getTasksByProjectId(UUID id);
    ResponseEntity<List<Tasks>> getTasksByUserId(UUID id);
}

