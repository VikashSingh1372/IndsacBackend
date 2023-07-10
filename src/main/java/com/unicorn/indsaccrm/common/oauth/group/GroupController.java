package com.unicorn.indsaccrm.common.oauth.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<?> saveGroup(@RequestBody Groups request) throws Exception {
        return ResponseEntity.ok(groupService.saveGroup(request));
    }

    @PostMapping("/all")
    public ResponseEntity<?> saveAllGroups(@RequestBody List<Groups> request) throws Exception {
        return ResponseEntity.ok(groupService.saveAllGroups(request));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllGroups() throws Exception {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByGroupId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(groupService.getByGroupId(id));
    }
}
