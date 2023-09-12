package com.unicorn.indsaccrm.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Override
    public ResponseEntity<?> saveCompany(Company company) {
        logger.info("Save Company inside saveCompany successfully ");
        return ResponseEntity.ok(companyRepository.save(company));
    }

    @Override
    public ResponseEntity<List<Company>> getAllCompanies() {
        logger.info("GET all Companies inside getAllCompanies successfully ");
        return ResponseEntity.ok(companyRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Company>> getCompanyById(UUID id) {
        logger.info("GET Company inside getCompanyById successfully ");
        return ResponseEntity.ok(companyRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<Company>> getCompanyByUseradminid(UUID id) {
        logger.info("GET Company By useradminid inside getCompanyByUseradminid successfully ");
        return ResponseEntity.ok(companyRepository.findByUseradminid(id));
    }

    @Override
    public ResponseEntity<List<Company>> getCompanyByUsercid(UUID id) {
        logger.info("GET Company By usercid inside getCompanyByUsercid successfully ");
        return ResponseEntity.ok(companyRepository.findByUsercid(id));
    }

    @Override
    public ResponseEntity<List<Company>> getCompanyByOwneruserid(UUID id) {
        logger.info("GET Company By owner_userid inside getCompanyByOwner_userid successfully ");
        return ResponseEntity.ok(companyRepository.findByOwner(id));
    }

}
