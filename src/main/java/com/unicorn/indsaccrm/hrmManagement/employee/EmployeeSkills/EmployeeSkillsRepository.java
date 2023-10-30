package com.unicorn.indsaccrm.hrmManagement.employee.EmployeeSkills;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkills, UUID> {
    List<EmployeeSkills> findByEmployeeid(UUID employeeid);
    List<EmployeeSkills> findByUsercid(UUID usercid);
    List<EmployeeSkills> findByUseradminid(UUID useradminid);
}
