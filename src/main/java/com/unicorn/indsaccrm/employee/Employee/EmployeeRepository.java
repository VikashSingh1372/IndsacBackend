package com.unicorn.indsaccrm.employee.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    List<Employee> findByJobid(UUID jobid);
    List<Employee> findByManagerid(UUID managerid);
    List<Employee> findByDepartmentid(UUID departmentid);
    List<Employee> findByUsercid(UUID usercid);
    List<Employee> findByUseradminid(UUID useradminid);
}
