package com.unicorn.indsaccrm.common.user.usereducation;

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
public class UserEducationServiceImpl implements UserEducationService {
    Logger logger= LoggerFactory.getLogger(UserEducationController.class);

    @Autowired
    UserEducationRepository userEducationRepository ;
    @Override
    public ResponseEntity<?> saveUserEducation(UserEducation request) {
        logger.info("UserEducation Saved Successfully");
        return  new ResponseEntity<>(userEducationRepository.save(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserEducation>> getAllUserEducationByUser(UUID userid) {
        logger.info("Get all id Successful");
        return ResponseEntity.ok(userEducationRepository.findByUserid(userid));
    }

    @Override
    public ResponseEntity<Optional<UserEducation>> getByUserEducationId(UUID id) {
        logger.info("Get by id Successful");
        return   ResponseEntity.ok(userEducationRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<UserEducation>> getAllUsers() {
        logger.info("Get all Successful");
        return ResponseEntity.ok(userEducationRepository.findAll());
    }

}

