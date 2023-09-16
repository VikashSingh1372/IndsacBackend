package com.unicorn.indsaccrm.employee.Job;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<Job, UUID> {
    List<Job> findByUsercid(UUID usercid);
    List<Job> findByUseradminid(UUID useradminid);
}
