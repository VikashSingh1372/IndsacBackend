package com.unicorn.indsaccrm.employee.EmployeeSkills;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService{
    @Autowired
    EmployeeSkillsRepository employeeSkillsRepository;
    Logger logger= LoggerFactory.getLogger(EmployeeSkillsServiceImpl.class);
    @Override
    public ResponseEntity<?> saveEmployeeSkills(EmployeeSkills employeeSkills) {
        logger.info("Save EmployeeSkills from saveEmployeeSkills successfully");
        return ResponseEntity.ok(employeeSkillsRepository.save(employeeSkills));
    }

    @Override
    public ResponseEntity<List<EmployeeSkills>> getAllEmployeeSkills() {
        logger.info("Get All EmployeeSkills from getAllEmployeeSkills successfully");
        return ResponseEntity.ok(employeeSkillsRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<EmployeeSkills>> getEmployeeSkillsById(UUID id) {
        logger.info("Get EmployeeSkills By Id from getEmployeeSkillsById successfully");
        return ResponseEntity.ok(employeeSkillsRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<EmployeeSkills>> getEmployeeSkillsByEmployeeid(UUID id) {
        logger.info("Get EmployeeSkills By Employeeid from getEmployeeSkillsByEmployeeid successfully");
        return ResponseEntity.ok(employeeSkillsRepository.findByEmployeeid(id));
    }

    @Override
    public ResponseEntity<List<EmployeeSkills>> getEmployeeSkillsByUsercid(UUID id) {
        logger.info("Get EmployeeSkills By Usercid from getEmployeeSkillsByUsercid successfully");
        return ResponseEntity.ok(employeeSkillsRepository.findByUsercid(id));
    }

    @Override
    public ResponseEntity<List<EmployeeSkills>> getEmployeeSkillsByUseradminid(UUID id) {
        logger.info("Get EmployeeSkills By Useradminid from getEmployeeSkillsByUseradminid successfully");
        return ResponseEntity.ok(employeeSkillsRepository.findByUseradminid(id));
    }
}
