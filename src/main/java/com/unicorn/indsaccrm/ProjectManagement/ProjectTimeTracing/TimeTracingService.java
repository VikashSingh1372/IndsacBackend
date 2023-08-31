package com.unicorn.indsaccrm.ProjectManagement.ProjectTimeTracing;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TimeTracingService {
    ResponseEntity<?> saveTimeTracing(TimeTracing timeTracing);

    ResponseEntity<List<TimeTracing>> getAllTimeTracing();

    ResponseEntity<Optional<TimeTracing>> getTimeTracingById(UUID id);

    ResponseEntity<List<TimeTracing>> getTimeTracingByTasksId(UUID id);

    ResponseEntity<List<TimeTracing>> getTimeTracingByUserId(UUID id);
}

