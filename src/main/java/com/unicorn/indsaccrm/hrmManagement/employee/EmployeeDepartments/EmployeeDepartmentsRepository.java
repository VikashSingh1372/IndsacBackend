package com.unicorn.indsaccrm.hrmManagement.employee.EmployeeDepartments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeDepartmentsRepository extends JpaRepository<EmployeeDepartments, UUID> {
    List<EmployeeDepartments> findByEmployeeid(UUID employeeid);
    List<EmployeeDepartments> findByUsercid(UUID usercid);
    List<EmployeeDepartments> findByUseradminid(UUID useradminid);



}
