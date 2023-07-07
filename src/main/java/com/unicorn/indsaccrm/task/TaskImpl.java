package com.unicorn.indsaccrm.task;

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
public class TaskImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;

    Logger logger = LoggerFactory.logger(TaskImpl.class);
    @Override
    public ResponseEntity<?> saveAllTask(Task task) {
        taskRepository.save(task);
        return new ResponseEntity<>("save all task successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Task>> getAllTask() {
        logger.info("all task getting successfully");
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Task>> getByIdtask(UUID id) {
        logger.info("all task getting by id");
        return ResponseEntity.ok(taskRepository.findById(id));
    }
}
