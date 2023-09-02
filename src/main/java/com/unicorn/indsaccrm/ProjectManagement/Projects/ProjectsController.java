package com.unicorn.indsaccrm.ProjectManagement.Projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectsController {

    @Autowired
    ProjectsService projectsService;

    @PostMapping
    ResponseEntity<?> createProjects(@RequestBody Projects projects)throws Exception{
        return ResponseEntity.ok(projectsService.saveProjects(projects));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllProjects()throws Exception{
        return ResponseEntity.ok(projectsService.getProjects());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getProjectsByID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(projectsService.getProjectsById(id));
    }

    @GetMapping("/userId/{id}")
    ResponseEntity<?> getProjectsByUserID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(projectsService.getProjectsByUserId(id));
    }
}

