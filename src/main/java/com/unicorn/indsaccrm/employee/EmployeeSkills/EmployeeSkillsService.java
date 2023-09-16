package com.unicorn.indsaccrm.employee.EmployeeSkills;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeSkillsService {
    ResponseEntity<?> saveEmployeeSkills(EmployeeSkills employeeSkills);
    ResponseEntity<List<EmployeeSkills>> getAllEmployeeSkills();
    ResponseEntity<Optional<EmployeeSkills>> getEmployeeSkillsById(UUID id);
    ResponseEntity<List<EmployeeSkills>> getEmployeeSkillsByEmployeeid(UUID id);
    ResponseEntity<List<EmployeeSkills>> getEmployeeSkillsByUsercid(UUID id);
    ResponseEntity<List<EmployeeSkills>> getEmployeeSkillsByUseradminid(UUID id);
}
