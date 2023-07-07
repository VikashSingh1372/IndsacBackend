package com.unicorn.indsaccrm.defaultvalues;

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
public class DefaultValuesImpl implements DefaultValuesService{
    @Autowired
    DefaultValuesRepository defaultValuesRepository;
    Logger logger= LoggerFactory.getLogger(DefaultValuesImpl.class);
    @Override
    public ResponseEntity<?> saveAllValues(DefaultValues request) {
        defaultValuesRepository.save(request);
        return new ResponseEntity<>("save all successsfull", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DefaultValues>> getAllValue() {
        logger.info("get all values");
        return ResponseEntity.ok(defaultValuesRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<DefaultValues>> getByIdValues(UUID id) {
        logger.info("get by id values");
        return ResponseEntity.ok(defaultValuesRepository.findById(id)) ;
    }
}
