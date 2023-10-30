package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.hiringteam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/hiringteam")
public class HiringTeamController {
    @Autowired
    private HiringTeamService hiringTeamService;
    @PostMapping
    ResponseEntity<?> createHiringTeam(@RequestBody HiringTeam hiringTeam) throws Exception {
        return ResponseEntity.ok(hiringTeamService.saveHiringTeam(hiringTeam));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllHiringTeam() throws Exception {
        return ResponseEntity.ok(hiringTeamService.getAllHiringTeams());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getHiringTeamByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(hiringTeamService.getHiringTeamById(id));
    }
    @GetMapping("/departmentid/{id}")
    ResponseEntity<?> getHiringTeamByDepartmentid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(hiringTeamService.getHiringTeamByDepartmentid(id));
    }
    @GetMapping("/jobid/{id}")
    ResponseEntity<?> getHiringTeamByJobid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(hiringTeamService.getHiringTeamByJobid(id));
    }
    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getHiringTeamByUsercid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(hiringTeamService.getHiringTeamByUsercid(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getHiringTeamByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(hiringTeamService.getHiringTeamByUseradminid(id));
    }
}