package com.unicorn.indsaccrm.employee.Job;

import com.unicorn.indsaccrm.employee.EmployeeSkills.EmployeeSkills;
import com.unicorn.indsaccrm.employee.EmployeeSkills.EmployeeSkillsRepository;
import com.unicorn.indsaccrm.employee.EmployeeSkills.EmployeeSkillsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobServiceImpl implements JobService{
    @Autowired
    JobRepository jobRepository;
    Logger logger= LoggerFactory.getLogger(JobServiceImpl.class);
    @Override
    public ResponseEntity<?> saveJob(Job job) {
        logger.info("Save Job from saveJob successfully");
        return ResponseEntity.ok(jobRepository.save(job));
    }

    @Override
    public ResponseEntity<List<Job>> getAllJobs() {
        logger.info("Get All Jobs from getAllJobs successfully");
        return ResponseEntity.ok(jobRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Job>> getJobById(UUID id) {
        logger.info("Get Job By Id from getJobById successfully");
        return ResponseEntity.ok(jobRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<Job>> getJobByUsercid(UUID id) {
        logger.info("Get Job By Usercid from getJobByUsercid successfully");
        return ResponseEntity.ok(jobRepository.findByUsercid(id));
    }

    @Override
    public ResponseEntity<List<Job>> getJobByUseradminid(UUID id) {
        logger.info("Get Job By Useradminid from getJobByUseradminid successfully");
        return ResponseEntity.ok(jobRepository.findByUseradminid(id));
    }
}
