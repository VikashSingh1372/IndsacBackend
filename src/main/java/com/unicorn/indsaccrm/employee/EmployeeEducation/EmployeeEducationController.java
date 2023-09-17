package com.unicorn.indsaccrm.employee.EmployeeEducation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/education")
public class EmployeeEducationController {
    @Autowired
    EmployeeEducationService employeeEducationService;
    @PostMapping
    ResponseEntity<?> saveEmployeeEducation(@RequestBody EmployeeEducation employeeEducation){
        return ResponseEntity.ok(employeeEducationService.saveEmployeeEducation(employeeEducation));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllEmployeeEducation()throws Exception {
        return ResponseEntity.ok(employeeEducationService.getAllEmployeeEducation());
    }
    //primary key
    @GetMapping("/{id}")
    ResponseEntity<?> getEmployeeEducationById(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeEducationService.getEmployeeEducationById(id));
    }
    @GetMapping("/employeeid/{id}")
    ResponseEntity<?> getEmployeeEducationByEmployeeid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeEducationService.getEmployeeEducationByEmployeeid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getEmployeeEducationByUsercid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeEducationService.getEmployeeEducationByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getEmployeeEducationByUseradminid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeEducationService.getEmployeeEducationByUseradminid(id));
    }
}
