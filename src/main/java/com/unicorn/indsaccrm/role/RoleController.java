package com.unicorn.indsaccrm.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<?> saveRole(@RequestBody Role request) throws Exception {
        return ResponseEntity.ok(roleService.saveRole(request));
    }

    @PostMapping("/all")
    public ResponseEntity<?> saveAllRoles(@RequestBody List<Role> request) throws Exception {
        return ResponseEntity.ok(roleService.saveAllRoles(request));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCourseCards() throws Exception {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByCourseId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(roleService.getByRoleId(id));
    }
}
