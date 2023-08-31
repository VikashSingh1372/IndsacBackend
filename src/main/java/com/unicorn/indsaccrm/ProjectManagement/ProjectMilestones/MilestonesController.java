package com.unicorn.indsaccrm.ProjectManagement.ProjectMilestones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RequestMapping("/milestones")
@RestController
public class MilestonesController {
    @Autowired
    MilestonesService milestonesService;

    @PostMapping
    ResponseEntity<?> createMilestones(@RequestBody Milestones milestones)throws Exception{
        return ResponseEntity.ok(milestonesService.saveMilestones(milestones));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllMilestones()throws Exception{
        return ResponseEntity.ok(milestonesService.getAllMilestones());
    }

    @GetMapping("{id}")
    ResponseEntity<?> getMilestonesByID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(milestonesService.getMilestonesById(id));
    }

    @GetMapping("/projectId/{id}")
    ResponseEntity<?> getMilestonesByProjectID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(milestonesService.getMilestonesByProjectId(id));
    }

}
