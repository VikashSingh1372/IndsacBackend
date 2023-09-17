package com.unicorn.indsaccrm.employee.EmployeeEducation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeEducationRepository extends JpaRepository<EmployeeEducation, UUID> {
    List<EmployeeEducation> findByEmployeeid(UUID employeeid);
    List<EmployeeEducation> findByUsercid(UUID usercid);
    List<EmployeeEducation> findByUseradminid(UUID useradminid);
}
