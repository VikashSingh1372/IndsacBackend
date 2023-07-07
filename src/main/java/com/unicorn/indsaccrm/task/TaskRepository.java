package com.unicorn.indsaccrm.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import java.util.UUID;
@Service
public interface TaskRepository extends JpaRepository<Task, UUID> {
}
