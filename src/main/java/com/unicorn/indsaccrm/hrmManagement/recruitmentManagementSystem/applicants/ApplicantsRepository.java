package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applicants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface ApplicantsRepository extends JpaRepository<Applicants,UUID> {
    List<Applicants> findByJobid(UUID jobid);
    List<Applicants> findByUsercid(UUID usercid);
    List<Applicants> findByUseradminid(UUID useradminid);
}
