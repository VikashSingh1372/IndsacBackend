package com.unicorn.indsaccrm.employee.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Override
    public ResponseEntity<?> saveEmployee(Employee employee) {
        logger.info("Save Employee from saveEmployee successfully");
        return ResponseEntity.ok(employeeRepository.save(employee));
    }
    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() {
        logger.info("Get All Employees from getAllEmployees successfully");
        return ResponseEntity.ok(employeeRepository.findAll());
    }
    @Override
    public ResponseEntity<Optional<Employee>> getEmployeeById(UUID id) {
        logger.info("Get Employee By Id from getEmployeeById successfully");
        return ResponseEntity.ok(employeeRepository.findById(id));
    }
    @Override
    public ResponseEntity<List<Employee>> getEmployeeByJobid(UUID id) {
        logger.info("Get Employee By Jobid from getEmployeeByJobid successfully");
        return ResponseEntity.ok(employeeRepository.findByJobid(id));
    }
    @Override
    public ResponseEntity<List<Employee>> getEmployeeByManagerid(UUID id) {
        logger.info("Get Employee By Managerid from getEmployeeByManagerid successfully");
        return ResponseEntity.ok(employeeRepository.findByManagerid(id));
    }
    @Override
    public ResponseEntity<List<Employee>> getEmployeeByDepartmentid(UUID id) {
        logger.info("Get Employee By Departmentid from getEmployeeByDepartmentid successfully");
        return ResponseEntity.ok(employeeRepository.findByDepartmentid(id));
    }
    @Override
    public ResponseEntity<List<Employee>> getEmployeeByUsercid(UUID id) {
        logger.info("Get Employee By Usercid from getEmployeeByUsercid successfully");
        return ResponseEntity.ok(employeeRepository.findByUsercid(id));
    }
    @Override
    public ResponseEntity<List<Employee>> getEmployeeByUseradminid(UUID id) {
        logger.info("Get Employee By Useradminid from getEmployeeByUseradminid successfully");
        return ResponseEntity.ok(employeeRepository.findByUseradminid(id));
    }
}
