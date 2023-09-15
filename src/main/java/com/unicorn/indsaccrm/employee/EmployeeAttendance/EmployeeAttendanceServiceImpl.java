package com.unicorn.indsaccrm.employee.EmployeeAttendance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeAttendanceServiceImpl implements EmployeeAttendanceService {
    @Autowired
    EmployeeAttendanceRepository employeeAttendanceRepository;
    Logger logger= LoggerFactory.getLogger(EmployeeAttendanceServiceImpl.class);
    @Override
    public ResponseEntity<?> saveEmployeeAttedance(EmployeeAttendance employeeAttendance) {
        logger.info("Save EmployeeAttendance from saveEmployeeAttedance successfully");
        return ResponseEntity.ok(employeeAttendanceRepository.save(employeeAttendance));
    }
    @Override
    public ResponseEntity<List<EmployeeAttendance>> getAllEmployeeAttendance() {
        logger.info("Get all EmployeeAttendance from getAllEmployeeAttendance successfully");
        return ResponseEntity.ok(employeeAttendanceRepository.findAll());
    }
    @Override
    public ResponseEntity<Optional<EmployeeAttendance>> getEmployeeAttedanceById(UUID id) {
        logger.info("Get EmployeeAttendance By Id from getEmployeeAttedanceById successfully");
        return ResponseEntity.ok(employeeAttendanceRepository.findById(id));
    }
    @Override
    public ResponseEntity<List<EmployeeAttendance>> getEmployeeAttendanceByEmployeeid(UUID id) {
        logger.info("Get EmployeeAttendance By Employeeid from getEmployeeAttendanceByEmployeeid successfully");
        return ResponseEntity.ok(employeeAttendanceRepository.findByEmployeeid(id));
    }
    @Override
    public ResponseEntity<List<EmployeeAttendance>> getEmployeeAttendanceByUsercid(UUID id) {
        logger.info("Get EmployeeAttendance By Usercid from getEmployeeAttendanceByUsercid successfully");
        return ResponseEntity.ok(employeeAttendanceRepository.findByUsercid(id));
    }
    @Override
    public ResponseEntity<List<EmployeeAttendance>> getEmployeeAttendanceByUseradminid(UUID id) {
        logger.info("Get EmployeeAttendance By Useradminid from getEmployeeAttendanceByUseradminid successfully");
        return ResponseEntity.ok(employeeAttendanceRepository.findByUseradminid(id));
    }
}
