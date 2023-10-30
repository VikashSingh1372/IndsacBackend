package com.unicorn.indsaccrm.hrmManagement.employee.EmployeeAttendance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance, UUID> {
    List<EmployeeAttendance> findByEmployeeid(UUID employeeid);
    List<EmployeeAttendance> findByUsercid(UUID usercid);
    List<EmployeeAttendance> findByUseradminid(UUID useradminid);
}
