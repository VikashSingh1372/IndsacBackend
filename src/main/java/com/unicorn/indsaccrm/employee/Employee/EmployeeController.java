package com.unicorn.indsaccrm.employee.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping
    ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllEmployees()throws Exception {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    //primary key
    @GetMapping("/{id}")
    ResponseEntity<?> getEmployeeById(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    @GetMapping("/jobid/{id}")
    ResponseEntity<?> getEmployeeByJobid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeService.getEmployeeByJobid(id));
    }
    @GetMapping("/managerid/{id}")
    ResponseEntity<?> getEmployeeByManagerid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeService.getEmployeeByManagerid(id));
    }
    @GetMapping("/departmentid/{id}")
    ResponseEntity<?> getEmployeeByDepartmentid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeService.getEmployeeByDepartmentid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getEmployeeByUsercid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeService.getEmployeeByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getEmployeeByUseradminid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeService.getEmployeeByUseradminid(id));
    }
}
