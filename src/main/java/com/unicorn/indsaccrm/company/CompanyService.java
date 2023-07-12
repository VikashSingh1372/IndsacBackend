package com.unicorn.indsaccrm.company;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyService {

    ResponseEntity<?> saveCompany(Company company);

    ResponseEntity<List<Company>> getAllCompanies();

    ResponseEntity<Optional<Company>> getCompanyById(UUID id);

    ResponseEntity<List<Company>> getCompanyByUseradminid(UUID id);

    ResponseEntity<List<Company>> getCompanyByUsercid(UUID id);

    ResponseEntity<List<Company>> getCompanyByOwneruserid(UUID id);

}
