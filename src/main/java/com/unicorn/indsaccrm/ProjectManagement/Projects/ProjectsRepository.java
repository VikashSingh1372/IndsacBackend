package com.unicorn.indsaccrm.ProjectManagement.Projects;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProjectsRepository extends JpaRepository<Projects, UUID> {
    List<Projects> findByUserId(UUID userId);

}

