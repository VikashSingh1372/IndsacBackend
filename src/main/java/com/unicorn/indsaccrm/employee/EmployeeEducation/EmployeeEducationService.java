package com.unicorn.indsaccrm.employee.EmployeeEducation;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeEducationService {
    ResponseEntity<?> saveEmployeeEducation(EmployeeEducation employeeEducation);
    ResponseEntity<List<EmployeeEducation>> getAllEmployeeEducation();
    ResponseEntity<Optional<EmployeeEducation>> getEmployeeEducationById(UUID id);
    ResponseEntity<List<EmployeeEducation>> getEmployeeEducationByEmployeeid(UUID id);
    ResponseEntity<List<EmployeeEducation>> getEmployeeEducationByUsercid(UUID id);
    ResponseEntity<List<EmployeeEducation>> getEmployeeEducationByUseradminid(UUID id);
}
