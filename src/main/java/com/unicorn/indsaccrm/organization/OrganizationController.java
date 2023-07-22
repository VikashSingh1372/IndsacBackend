package com.unicorn.indsaccrm.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    OrganizationSerive organizationSerive;
    @PostMapping
    ResponseEntity<?> saveOrganization(@RequestBody Organization organization)throws Exception{
        return ResponseEntity.ok(organizationSerive.saveOrganization(organization));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllOrganizations()throws Exception{
        return ResponseEntity.ok(organizationSerive.getAllOrganizations());
    }

    @GetMapping("{id}")
    ResponseEntity<?> getOrganizationByID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(organizationSerive.getOrganizationById(id));
    }

    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getOrganizationByUseradminid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(organizationSerive.getOrganizationByUseradminid(id));
    }

    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getOrganizationByUsercid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(organizationSerive.getOrganizationByUsercid(id));
    }

    @GetMapping("/owneruserid/{id}")
    ResponseEntity<?> getOrganizationByOwneruserid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(organizationSerive.getOrganizationByOwneruserid(id));
    }

}
