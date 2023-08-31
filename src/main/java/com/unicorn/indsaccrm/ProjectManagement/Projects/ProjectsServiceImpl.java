package com.unicorn.indsaccrm.ProjectManagement.Projects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ProjectsServiceImpl implements ProjectsService{


    @Autowired
    ProjectsRepository projectsRepository;

    Logger logger = LoggerFactory.getLogger(ProjectsServiceImpl.class);

    @Override
    public ResponseEntity<?> saveProjects(Projects projects) {
        logger.info("Save projects from saveProjects Successully");
        return ResponseEntity.ok(projectsRepository.save(projects));
    }

    @Override
    public ResponseEntity<List<Projects>> getProjects() {
        logger.info("Get all projects from getProjects Successully");
        return ResponseEntity.ok(projectsRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Projects>> getProjectsById(UUID id) {
        logger.info("Get projects by id from getProjectsById Successully");
        return ResponseEntity.ok(projectsRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<Projects>> getProjectsByUserId(UUID id) {
        logger.info("Get projects by UserId from getProjectsByUserId Successully");
        return ResponseEntity.ok(projectsRepository.findByUserId(id));
    }
}

