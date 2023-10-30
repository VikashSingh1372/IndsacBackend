package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.hiringteam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface HiringTeamRepository extends JpaRepository<HiringTeam,UUID> {
    List<HiringTeam> findByDepartmentid(UUID departmentid);
    List<HiringTeam> findByJobid(UUID jobid);
    List<HiringTeam> findByUsercid(UUID usercid);
    List<HiringTeam> findByUseradminid(UUID useradminid);
}
