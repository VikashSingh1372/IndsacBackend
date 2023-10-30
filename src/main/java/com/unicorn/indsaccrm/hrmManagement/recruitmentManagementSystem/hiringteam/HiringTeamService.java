package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.hiringteam;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface HiringTeamService {
    ResponseEntity<?> saveHiringTeam(HiringTeam hiringTeam);
    ResponseEntity<List<HiringTeam>> getAllHiringTeams();
    ResponseEntity<Optional<HiringTeam>> getHiringTeamById(UUID id);
    ResponseEntity<List<HiringTeam>> getHiringTeamByDepartmentid(UUID id);
    ResponseEntity<List<HiringTeam>> getHiringTeamByJobid(UUID id);
    ResponseEntity<List<HiringTeam>> getHiringTeamByUsercid(UUID id);
    ResponseEntity<List<HiringTeam>> getHiringTeamByUseradminid(UUID id);
}