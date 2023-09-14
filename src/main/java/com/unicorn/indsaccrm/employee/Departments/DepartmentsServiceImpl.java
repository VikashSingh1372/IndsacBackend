package com.unicorn.indsaccrm.employee.Departments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{

    @Autowired
    DepartmentsRepository departmentsRepository;

    Logger logger= LoggerFactory.getLogger(DepartmentsServiceImpl.class);

    @Override
    public ResponseEntity<?> saveDepartments(Departments departments) {
        logger.info("Save Departments from saveDepartments Successfully");
        return ResponseEntity.ok(departmentsRepository.save(departments));
    }

    @Override
    public ResponseEntity<List<Departments>> getAllDepartments() {
        logger.info("Get all Departments from getAllDepartments Successfully");
        return ResponseEntity.ok(departmentsRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Departments>> getDepartmentsById(UUID id) {
        logger.info("Get Departments By Id from getDepartmentsById Successfully");
        return ResponseEntity.ok(departmentsRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<Departments>> getDepartmentsByUseradminid(UUID id) {
        logger.info("Get Departments By Useradminid from getDepartmentsByUseradminid Successfully");
        return ResponseEntity.ok(departmentsRepository.findByUseradminid(id));
    }

    @Override
    public ResponseEntity<List<Departments>> getDepartmentsByUsercid(UUID id) {
        logger.info("Get Departments By Usercid from getDepartmentsByUsercid Successfully");
        return ResponseEntity.ok(departmentsRepository.findByUsercid(id));
    }
}
