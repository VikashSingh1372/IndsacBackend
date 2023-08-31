package com.unicorn.indsaccrm.ProjectManagement.ProjectTimeTracing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/timetracing")
public class TimeTracingController {

    @Autowired
    TimeTracingService timeTracingService;

    @PostMapping
    ResponseEntity<?> createTimeTracing(@RequestBody TimeTracing timeTracing)throws Exception{
        return ResponseEntity.ok(timeTracingService.saveTimeTracing(timeTracing));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllTimeTracings()throws Exception{
        return ResponseEntity.ok(timeTracingService.getAllTimeTracing());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getTimeTracingByID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(timeTracingService.getTimeTracingById(id));
    }

    @GetMapping("/tasksId/{id}")
    ResponseEntity<?> getTimeTracingByTasksID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(timeTracingService.getTimeTracingByTasksId(id));
    }

    @GetMapping("/userId/{id}")
    ResponseEntity<?> getTimeTracingByUserID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(timeTracingService.getTimeTracingByUserId(id));
    }
}

