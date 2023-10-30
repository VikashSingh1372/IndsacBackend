package com.unicorn.indsaccrm.hrmManagement.employee.EmployeeDepartments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/employeedepartments")
public class EmployeeDepartmentsController {
    @Autowired
    EmployeeDepartmentsService employeeDepartmentsService;
    @PostMapping
    ResponseEntity<?> saveEmployeeDepartment(@RequestBody EmployeeDepartments employeeDepartments){
        return ResponseEntity.ok(employeeDepartmentsService.saveEmployeeDepartment(employeeDepartments));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllEmployeeDepartments()throws Exception {
        return ResponseEntity.ok(employeeDepartmentsService.getAllEmployeeDepartments());
    }
    //primary key
    @GetMapping("/{id}")
    ResponseEntity<?> getEmployeeDepartmentById(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeDepartmentsService.getEmployeeDepartmentById(id));
    }
    @GetMapping("/employeeid/{id}")
    ResponseEntity<?> getEmployeeDepartmentByEmployeeid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeDepartmentsService.getEmployeeDepartmentByEmployeeid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getEmployeeDepartmentByUsercid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeDepartmentsService.getEmployeeDepartmentByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getEmployeeDepartmentByUseradminid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeDepartmentsService.getEmployeeDepartmentByUseradminid(id));
    }
}
