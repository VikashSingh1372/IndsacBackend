package com.unicorn.indsaccrm.employee.EmployeeEducation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeEducationServiceImpl implements EmployeeEducationService{
    @Autowired
    EmployeeEducationRepository employeeEducationRepository;
    Logger logger= LoggerFactory.getLogger(EmployeeEducationServiceImpl.class);
    @Override
    public ResponseEntity<?> saveEmployeeEducation(EmployeeEducation employeeEducation) {
        logger.info("Save EmployeeEducation from saveEmployeeEducation successfully");
        return ResponseEntity.ok(employeeEducationRepository.save(employeeEducation));
    }
    @Override
    public ResponseEntity<List<EmployeeEducation>> getAllEmployeeEducation() {
        logger.info("Get All EmployeeEducation from getAllEmployeeEducation successfully");
        return ResponseEntity.ok(employeeEducationRepository.findAll());
    }
    @Override
    public ResponseEntity<Optional<EmployeeEducation>> getEmployeeEducationById(UUID id) {
        logger.info("Get EmployeeEducation By Id from getEmployeeEducationById successfully");
        return ResponseEntity.ok(employeeEducationRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<EmployeeEducation>> getEmployeeEducationByEmployeeid(UUID id) {
        logger.info("Get EmployeeEducation By Employeeid from getEmployeeEducationByEmployeeid successfully");
        return ResponseEntity.ok(employeeEducationRepository.findByEmployeeid(id));
    }

    @Override
    public ResponseEntity<List<EmployeeEducation>> getEmployeeEducationByUsercid(UUID id) {
        logger.info("Get EmployeeEducation By Usercid from getEmployeeEducationByUsercid successfully");
        return ResponseEntity.ok(employeeEducationRepository.findByUsercid(id));
    }

    @Override
    public ResponseEntity<List<EmployeeEducation>> getEmployeeEducationByUseradminid(UUID id) {
        logger.info("Get EmployeeEducation By Useradminid from getEmployeeEducationByUseradminid successfully");
        return ResponseEntity.ok(employeeEducationRepository.findByUseradminid(id));
    }
}
