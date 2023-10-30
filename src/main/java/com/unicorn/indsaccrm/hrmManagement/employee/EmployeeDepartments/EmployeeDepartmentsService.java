package com.unicorn.indsaccrm.hrmManagement.employee.EmployeeDepartments;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeDepartmentsService {
    ResponseEntity<?> saveEmployeeDepartment(EmployeeDepartments employeeDepartments);
    ResponseEntity<List<EmployeeDepartments>> getAllEmployeeDepartments();
    ResponseEntity<Optional<EmployeeDepartments>> getEmployeeDepartmentById(UUID id);
    ResponseEntity<List<EmployeeDepartments>> getEmployeeDepartmentByEmployeeid(UUID id);
    ResponseEntity<List<EmployeeDepartments>> getEmployeeDepartmentByUsercid(UUID id);
    ResponseEntity<List<EmployeeDepartments>> getEmployeeDepartmentByUseradminid(UUID id);
}
