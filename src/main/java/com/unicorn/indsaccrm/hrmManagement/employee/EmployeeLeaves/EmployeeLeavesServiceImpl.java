package com.unicorn.indsaccrm.hrmManagement.employee.EmployeeLeaves;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeLeavesServiceImpl implements EmployeeLeavesService{
    @Autowired
    EmployeeLeavesRepository employeeLeavesRepository;
    Logger logger= LoggerFactory.getLogger(EmployeeLeavesServiceImpl.class);
    @Override
    public ResponseEntity<?> saveEmployeeLeaves(EmployeeLeaves employeeLeaves) {
        logger.info("Save EmployeeLeaves from saveEmployeeLeaves successfully");
        return ResponseEntity.ok(employeeLeavesRepository.save(employeeLeaves));
    }

    @Override
    public ResponseEntity<List<EmployeeLeaves>> getAllEmployeeLeaves() {
        logger.info("Get All EmployeeLeaves from getAllEmployeeLeaves successfully");
        return ResponseEntity.ok(employeeLeavesRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<EmployeeLeaves>> getEmployeeLeavesById(UUID id) {
        logger.info("Get EmployeeLeaves By Id from getEmployeeLeavesById successfully");
        return ResponseEntity.ok(employeeLeavesRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<EmployeeLeaves>> getEmployeeLeavesByEmployeeid(UUID id) {
        logger.info("Get EmployeeLeaves By Employeeid from getEmployeeLeavesByEmployeeid successfully");
        return ResponseEntity.ok(employeeLeavesRepository.findByEmployeeid(id));
    }

    @Override
    public ResponseEntity<List<EmployeeLeaves>> getEmployeeLeavesByUsercid(UUID id) {
        logger.info("Get EmployeeLeaves By Usercid from getEmployeeLeavesByUsercid successfully");
        return ResponseEntity.ok(employeeLeavesRepository.findByUsercid(id));
    }

    @Override
    public ResponseEntity<List<EmployeeLeaves>> getEmployeeLeavesByUseradminid(UUID id) {
        logger.info("Get EmployeeLeaves By Useradminid from getEmployeeLeavesByUseradminid successfully");
        return ResponseEntity.ok(employeeLeavesRepository.findByUseradminid(id));
    }
}
