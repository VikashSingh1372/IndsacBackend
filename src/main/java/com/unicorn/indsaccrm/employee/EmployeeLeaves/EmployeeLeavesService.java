package com.unicorn.indsaccrm.employee.EmployeeLeaves;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeLeavesService {
    ResponseEntity<?> saveEmployeeLeaves(EmployeeLeaves employeeLeaves);
    ResponseEntity<List<EmployeeLeaves>> getAllEmployeeLeaves();
    ResponseEntity<Optional<EmployeeLeaves>> getEmployeeLeavesById(UUID id);
    ResponseEntity<List<EmployeeLeaves>> getEmployeeLeavesByEmployeeid(UUID id);
    ResponseEntity<List<EmployeeLeaves>> getEmployeeLeavesByUsercid(UUID id);
    ResponseEntity<List<EmployeeLeaves>> getEmployeeLeavesByUseradminid(UUID id);
}
