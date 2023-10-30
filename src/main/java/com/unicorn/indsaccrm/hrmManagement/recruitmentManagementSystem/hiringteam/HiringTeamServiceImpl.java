package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.hiringteam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HiringTeamServiceImpl implements HiringTeamService {
   @Autowired
   HiringTeamRepository hiringTeamRepository;
   Logger logger = LoggerFactory.getLogger(HiringTeamServiceImpl.class);
   @Override
   public ResponseEntity<?> saveHiringTeam(HiringTeam hiringTeam) {
      logger.info("Save HiringTeam from saveHiringTeam Successully");
      return ResponseEntity.ok(hiringTeamRepository.save(hiringTeam));
   }
   @Override
   public ResponseEntity<List<HiringTeam>> getAllHiringTeams() {
      logger.info("GET all HiringTeams from getAllHiringTeams Successully");
      return ResponseEntity.ok(hiringTeamRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<HiringTeam>> getHiringTeamById(UUID id) {
      logger.info("GET HiringTeam By Id from getHiringTeamById Successfully");
      return ResponseEntity.ok(hiringTeamRepository.findById(id));
   }

   @Override
   public ResponseEntity<List<HiringTeam>> getHiringTeamByDepartmentid(UUID id) {
      logger.info("GET All HiringTeams By Departmentid from getHiringTeamByDepartmentid Successfully");
      return ResponseEntity.ok(hiringTeamRepository.findByDepartmentid(id));
   }

   @Override
   public ResponseEntity<List<HiringTeam>> getHiringTeamByJobid(UUID id) {
      logger.info("GET All HiringTeams By Jobid from getHiringTeamByJobid Successfully");
      return ResponseEntity.ok(hiringTeamRepository.findByJobid(id));
   }

   @Override
   public ResponseEntity<List<HiringTeam>> getHiringTeamByUsercid(UUID id) {
      logger.info("GET All HiringTeams By Usercid from getHiringTeamByUsercid Successfully");
      return ResponseEntity.ok(hiringTeamRepository.findByUsercid(id));   }

   @Override
   public ResponseEntity<List<HiringTeam>> getHiringTeamByUseradminid(UUID id) {
      logger.info("GET All HiringTeams By Useradminid from getHiringTeamByUseradminid Successfully");
      return ResponseEntity.ok(hiringTeamRepository.findByUseradminid(id));   }
}