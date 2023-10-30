package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.jobs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface JobsRepository extends JpaRepository<Jobs,UUID> {
    List<Jobs> findByUsercid(UUID usercid);
    List<Jobs> findByUseradminid(UUID useradminid);
}
