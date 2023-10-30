package com.unicorn.indsaccrm.hrmManagement.employee.Departments;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DepartmentsService {

    ResponseEntity<?> saveDepartments(Departments departments);
    ResponseEntity<List<Departments>> getAllDepartments();
    ResponseEntity<Optional<Departments>> getDepartmentsById(UUID id);
    ResponseEntity<List<Departments>> getDepartmentsByUseradminid(UUID id);
    ResponseEntity<List<Departments>> getDepartmentsByUsercid(UUID id);
}
