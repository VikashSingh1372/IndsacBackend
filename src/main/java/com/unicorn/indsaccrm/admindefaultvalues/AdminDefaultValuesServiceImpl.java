package com.unicorn.indsaccrm.admindefaultvalues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminDefaultValuesServiceImpl implements AdminDefaultValuesService {

    Logger logger = LoggerFactory.getLogger(AdminDefaultValuesServiceImpl.class);
    @Autowired
    AdminDefaultValuesRepository adminDefaultValuesRepository;

    @Override
    public ResponseEntity<?> saveAdminDefaultValues(AdminDefaultValues request) {
        logger.info("AdminDefaultValues Saved Successfully");
        return  new ResponseEntity<>(adminDefaultValuesRepository.save(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AdminDefaultValues>> getAllAdminDefaultValues() {
        logger.info("Get ALL AdminDefaultValues Successfully");
        return  ResponseEntity.ok(adminDefaultValuesRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<AdminDefaultValues>> getByAdminDefaultValuesId(UUID id) {
        logger.info("Get ALL AdminDefaultValues Successfully");
        return   ResponseEntity.ok(adminDefaultValuesRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<AdminDefaultValues>> getAdminDefaultValuesByUsercid(String usercid) {
        logger.info("Get AdminDefaultValues from getAdminDefaultValuesByUsercid function Successfully");
        return ResponseEntity.ok(adminDefaultValuesRepository.findByUsercid(usercid));
    }
}
