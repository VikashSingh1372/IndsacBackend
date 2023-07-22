package com.unicorn.indsaccrm.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    ResponseEntity<?> createCompany(@RequestBody Company company)throws Exception{
        return ResponseEntity.ok(companyService.saveCompany(company));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllCompanies()throws Exception{
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("{id}")
    ResponseEntity<?> getCompanyByID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(companyService.getCompanyById(id));
    }

    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getCompanyByUseradminid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(companyService.getCompanyByUseradminid(id));
    }

    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getCompanyByUsercid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(companyService.getCompanyByUsercid(id));
    }

    @GetMapping("/owneruserid/{id}")
    ResponseEntity<?> getCompanyByOwneruserid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(companyService.getCompanyByOwneruserid(id));
    }

}
