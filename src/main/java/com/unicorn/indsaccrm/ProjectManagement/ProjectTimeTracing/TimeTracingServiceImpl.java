package com.unicorn.indsaccrm.ProjectManagement.ProjectTimeTracing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TimeTracingServiceImpl implements TimeTracingService{

    @Autowired
    TimeTracingRepository timeTracingRepository;

    Logger logger = LoggerFactory.getLogger(TimeTracingServiceImpl.class);

    @Override
    public ResponseEntity<?> saveTimeTracing(TimeTracing timeTracing) {
        logger.info("Save timeTracing from saveTimeTracing Successully");
        return ResponseEntity.ok(timeTracingRepository.save(timeTracing));
    }

    @Override
    public ResponseEntity<List<TimeTracing>> getAllTimeTracing() {
        logger.info("Get all timeTracing from getAllTimeTracing Successully");
        return ResponseEntity.ok(timeTracingRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<TimeTracing>> getTimeTracingById(UUID id) {
        logger.info("Get timeTracing by id from getTimeTracingById Successully");
        return ResponseEntity.ok(timeTracingRepository.findById(id));
    }
    @Override
    public ResponseEntity<List<TimeTracing>> getTimeTracingByTasksId(UUID id) {
        logger.info("Get timeTracing by tasksid from getTimeTracingByTasksId Successully");
        return ResponseEntity.ok(timeTracingRepository.findByTasksId(id));
    }

    @Override
    public ResponseEntity<List<TimeTracing>> getTimeTracingByUserId(UUID id) {
        logger.info("Get timeTracing by userid from getTimeTracingByUserId Successully");
        return ResponseEntity.ok(timeTracingRepository.findByUserId(id));
    }
}


