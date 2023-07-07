package com.unicorn.indsaccrm.admindefaultvalues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/admindefaultvalues")
public class AdminDefaultValuesController {

    @Autowired
    AdminDefaultValuesService adminDefaultValuesService;

    @PostMapping
    public ResponseEntity<?> adminDefaultValues(@RequestBody AdminDefaultValues values) throws Exception {
        return ResponseEntity.ok(adminDefaultValuesService.saveAdminDefaultValues(values));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAdminDefaultValues() throws Exception {
        return ResponseEntity.ok(adminDefaultValuesService.getAllAdminDefaultValues());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByuseradminId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(adminDefaultValuesService.getByAdminDefaultValuesId(id));
    }

    @GetMapping("/enterusercid/{id}")
    public ResponseEntity<?> getAdminDefaultValuesByUsercid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(adminDefaultValuesService.getAdminDefaultValuesByUsercid(id));
    }

    @GetMapping("/enteruseradminid/{id}")
    public ResponseEntity<?> getAdminDefaultValuesByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(adminDefaultValuesService.getAdminDefaultValuesByUseradminid(id));
    }
}
