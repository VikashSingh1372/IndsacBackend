package com.unicorn.indsaccrm.ProjectManagement.Projects;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectsService {

    ResponseEntity<?> saveProjects(Projects projects);

    ResponseEntity<List<Projects>> getProjects();

    ResponseEntity<Optional<Projects>> getProjectsById(UUID id);

    ResponseEntity<List<Projects>> getProjectsByUserId(UUID id);
}

