package com.unicorn.indsaccrm.ProjectManagement.ProjectTasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectTasksServiceImpl implements ProjectTasksService {

    @Autowired
    ProjectTasksRepository tasksRepository;

    Logger logger = LoggerFactory.getLogger(ProjectTasksServiceImpl.class);

    @Override
    public ResponseEntity<?> saveTasks(ProjectTasks tasks) {
        logger.info("Save tasks from saveTasks Successully");
        return ResponseEntity.ok(tasksRepository.save(tasks));
    }

    @Override
    public ResponseEntity<List<ProjectTasks>> getTasks() {
        logger.info("Get all tasks from getTasks Successully");
        return ResponseEntity.ok(tasksRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<ProjectTasks>> getTasksById(UUID id) {
        logger.info("Get tasks By id getTasksById Successully");
        return ResponseEntity.ok(tasksRepository.findById(id));
    }
    @Override
    public ResponseEntity<List<ProjectTasks>> getTasksByProjectId(UUID id) {
        logger.info("Get tasks By projectid getTasksByProjectId Successully");
        return ResponseEntity.ok(tasksRepository.findByProjectId(id));
    }
    @Override
    public ResponseEntity<List<ProjectTasks>> getTasksByUserId(UUID id) {
        logger.info("Get tasks By userid getTasksByUserId Successully");
        return ResponseEntity.ok(tasksRepository.findByUserId(id));
    }
}

