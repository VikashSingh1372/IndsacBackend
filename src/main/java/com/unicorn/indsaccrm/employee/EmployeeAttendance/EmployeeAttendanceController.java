package com.unicorn.indsaccrm.employee.EmployeeAttendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/employeeattendance")
public class EmployeeAttendanceController {
    @Autowired
    EmployeeAttendanceService employeeAttendanceService;
    @PostMapping
    ResponseEntity<?> saveEmployeeAttendence(@RequestBody EmployeeAttendance employeeAttendance){
        return ResponseEntity.ok(employeeAttendanceService.saveEmployeeAttedance(employeeAttendance));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllEmployeeAttendance()throws Exception {
        return ResponseEntity.ok(employeeAttendanceService.getAllEmployeeAttendance());
    }
    //primary key
    @GetMapping("/{id}")
    ResponseEntity<?> getEmployeeAttedanceById(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeAttendanceService.getEmployeeAttedanceById(id));
    }
    @GetMapping("/employeeid/{id}")
    ResponseEntity<?> getEmployeeAttendanceByEmployeeid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeAttendanceService.getEmployeeAttendanceByEmployeeid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getEmployeeAttendanceByUsercid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeAttendanceService.getEmployeeAttendanceByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getEmployeeAttendanceByUseradminid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(employeeAttendanceService.getEmployeeAttendanceByUseradminid(id));
    }
}
