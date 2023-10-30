package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.resumes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface ResumesRepository extends JpaRepository<Resumes,UUID> {
    List<Resumes> findByApplicantid(UUID applicantid);
    List<Resumes> findByUsercid(UUID usercid);
    List<Resumes> findByUseradminid(UUID useradminid);
}
