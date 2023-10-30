package com.unicorn.indsaccrm.hrmManagement.employee.EmployeeAttendance;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeAttendanceService {
    ResponseEntity<?> saveEmployeeAttedance(EmployeeAttendance employeeAttendance);
    ResponseEntity<List<EmployeeAttendance>> getAllEmployeeAttendance();
    ResponseEntity<Optional<EmployeeAttendance>> getEmployeeAttedanceById(UUID id);
    ResponseEntity<List<EmployeeAttendance>> getEmployeeAttendanceByEmployeeid(UUID id);
    ResponseEntity<List<EmployeeAttendance>> getEmployeeAttendanceByUsercid(UUID id);
    ResponseEntity<List<EmployeeAttendance>> getEmployeeAttendanceByUseradminid(UUID id);
}
