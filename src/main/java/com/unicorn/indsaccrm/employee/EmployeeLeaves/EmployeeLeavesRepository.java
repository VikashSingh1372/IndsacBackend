package com.unicorn.indsaccrm.employee.EmployeeLeaves;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeLeavesRepository extends JpaRepository<EmployeeLeaves, UUID> {
    List<EmployeeLeaves> findByEmployeeid(UUID employeeid);
    List<EmployeeLeaves> findByUsercid(UUID usercid);
    List<EmployeeLeaves> findByUseradminid(UUID useradminid);
}
