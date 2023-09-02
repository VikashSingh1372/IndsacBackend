package com.unicorn.indsaccrm.ProjectManagement.ProjectTasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/projecttask")
public class ProjectTasksController {

    @Autowired
    ProjectTasksService tasksService;

    @PostMapping
    ResponseEntity<?> createTasks(@RequestBody ProjectTasks tasks)throws Exception{
        return ResponseEntity.ok(tasksService.saveTasks(tasks));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllTasks()throws Exception{
        return ResponseEntity.ok(tasksService.getTasks());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getTasksByID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(tasksService.getTasksById(id));
    }
    @GetMapping("/projectId/{id}")
    ResponseEntity<?> getTasksByProjectID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(tasksService.getTasksByProjectId(id));
    }
    @GetMapping("/userId/{id}")
    ResponseEntity<?> getTasksByUserID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(tasksService.getTasksByUserId(id));
    }
}

