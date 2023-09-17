package com.unicorn.indsaccrm.employee.EmployeeLeaves;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/employeeleaves")
public class EmployeeLeavesController {
    @Autowired
    EmployeeLeavesService employeeLeavesService;
    @PostMapping
    ResponseEntity<?> saveEmployeeLeaves(@RequestBody EmployeeLeaves employeeLeaves){
        return ResponseEntity.ok(employeeLeavesService.saveEmployeeLeaves(employeeLeaves));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllEmployeeLeaves()throws Exception {
        return ResponseEntity.ok(employeeLeavesService.getAllEmployeeLeaves());
    }
    //primary key
    @GetMapping("/{id}")
    ResponseEntity<?> getEmployeeLeavesById(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeLeavesService.getEmployeeLeavesById(id));
    }
    @GetMapping("/employeeid/{id}")
    ResponseEntity<?> getEmployeeLeavesByEmployeeid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeLeavesService.getEmployeeLeavesByEmployeeid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getEmployeeLeavesByUsercid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeLeavesService.getEmployeeLeavesByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getEmployeeLeavesByUseradminid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeLeavesService.getEmployeeLeavesByUseradminid(id));
    }
}
