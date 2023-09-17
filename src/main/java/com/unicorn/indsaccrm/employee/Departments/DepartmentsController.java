package com.unicorn.indsaccrm.employee.Departments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    @Autowired
    DepartmentsService departmentsService;

    @PostMapping
    ResponseEntity<?> saveDepartments(@RequestBody Departments departments){
        return ResponseEntity.ok(departmentsService.saveDepartments(departments));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllDepartments()throws Exception {
        return ResponseEntity.ok(departmentsService.getAllDepartments());
    }

    //primary key
    @GetMapping("/{id}")
    ResponseEntity<?> getDepartmentsById(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(departmentsService.getDepartmentsById(id));
    }

    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getDepartmentsByUseradminid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(departmentsService.getDepartmentsByUseradminid(id));
    }

    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getDepartmentsByUsercid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(departmentsService.getDepartmentsByUsercid(id));
    }

}
