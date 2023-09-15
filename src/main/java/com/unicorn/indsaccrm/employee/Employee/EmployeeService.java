package com.unicorn.indsaccrm.employee.Employee;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {
    ResponseEntity<?> saveEmployee(Employee employee);
    ResponseEntity<List<Employee>> getAllEmployees();
    ResponseEntity<Optional<Employee>> getEmployeeById(UUID id);
    ResponseEntity<List<Employee>> getEmployeeByJobid(UUID id);
    ResponseEntity<List<Employee>> getEmployeeByManagerid(UUID id);
    ResponseEntity<List<Employee>> getEmployeeByDepartmentid(UUID id);
    ResponseEntity<List<Employee>> getEmployeeByUsercid(UUID id);
    ResponseEntity<List<Employee>> getEmployeeByUseradminid(UUID id);
}
