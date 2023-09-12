package com.unicorn.indsaccrm.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
@Service
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByCustomerid(UUID customerid);

    List<Task> findByUseradminid(UUID useradminid);

}
