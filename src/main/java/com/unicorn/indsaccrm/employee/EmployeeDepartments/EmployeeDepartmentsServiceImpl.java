package com.unicorn.indsaccrm.employee.EmployeeDepartments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeDepartmentsServiceImpl implements EmployeeDepartmentsService{
    @Autowired
    EmployeeDepartmentsRepository employeeDepartmentsRepository;
    Logger logger= LoggerFactory.getLogger(EmployeeDepartmentsServiceImpl.class);
    @Override
    public ResponseEntity<?> saveEmployeeDepartment(EmployeeDepartments employeeDepartments) {
        logger.info("Save EmployeeDepartment from saveEmployeeDepartment successfully");
        return ResponseEntity.ok(employeeDepartmentsRepository.save(employeeDepartments));
    }

    @Override
    public ResponseEntity<List<EmployeeDepartments>> getAllEmployeeDepartments() {
        logger.info("Get All EmployeeDepartments from getAllEmployeeDepartments successfully");
        return ResponseEntity.ok(employeeDepartmentsRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<EmployeeDepartments>> getEmployeeDepartmentById(UUID id) {
        logger.info("Get EmployeeDepartments By Id from getAllEmployeeDepartments successfully");
        return ResponseEntity.ok(employeeDepartmentsRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<EmployeeDepartments>> getEmployeeDepartmentByEmployeeid(UUID id) {
        logger.info("Get EmployeeDepartments By Employeeid from getEmployeeDepartmentByEmployeeid successfully");
        return ResponseEntity.ok(employeeDepartmentsRepository.findByEmployeeid(id));
    }

    @Override
    public ResponseEntity<List<EmployeeDepartments>> getEmployeeDepartmentByUsercid(UUID id) {
        logger.info("Get EmployeeDepartments By Usercid from getEmployeeDepartmentByUsercid successfully");
        return ResponseEntity.ok(employeeDepartmentsRepository.findByUsercid(id));
    }

    @Override
    public ResponseEntity<List<EmployeeDepartments>> getEmployeeDepartmentByUseradminid(UUID id) {
        logger.info("Get EmployeeDepartments By Useradminid from getEmployeeDepartmentByUseradminid successfully");
        return ResponseEntity.ok(employeeDepartmentsRepository.findByUsercid(id));
    }
}
