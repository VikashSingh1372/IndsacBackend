package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface ApplicationsRepository extends JpaRepository<Applications,UUID> {
    List<Applications> findByJobid(UUID jobid);
    List<Applications> findByApplicantid(UUID applicantid);
    List<Applications> findByUsercid(UUID usercid);
    List<Applications> findByUseradminid(UUID useradminid);
}
