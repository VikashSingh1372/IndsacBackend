package com.unicorn.indsaccrm.hrmManagement.employee.EmployeeSkills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/employeeskills")
public class EmployeeSkillsController {
    @Autowired
    EmployeeSkillsService employeeSkillsService;
    @PostMapping
    ResponseEntity<?> saveEmployeeSkills(@RequestBody EmployeeSkills employeeSkills){
        return ResponseEntity.ok(employeeSkillsService.saveEmployeeSkills(employeeSkills));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllEmployeeSkills()throws Exception {
        return ResponseEntity.ok(employeeSkillsService.getAllEmployeeSkills());
    }
    //primary key
    @GetMapping("/{id}")
    ResponseEntity<?> getEmployeeSkillsById(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeSkillsService.getEmployeeSkillsById(id));
    }
    @GetMapping("/employeeid/{id}")
    ResponseEntity<?> getEmployeeSkillsByEmployeeid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeSkillsService.getEmployeeSkillsByEmployeeid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getEmployeeSkillsByUsercid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeSkillsService.getEmployeeSkillsByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getEmployeeSkillsByUseradminid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeSkillsService.getEmployeeSkillsByUseradminid(id));
    }
}
