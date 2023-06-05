package com.unicorn.indsaccrm.practiceresource.answer;
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
public class TSAnswerImpl implements TSAnswerService {
    @Autowired
    TSAnswerRepository tsAnswerRepository;
    Logger logger = LoggerFactory.getLogger(TSAnswerImpl.class);
  @Override
    public ResponseEntity<?> saveanswer(TSAnswer requestanswer) {
        tsAnswerRepository.save(requestanswer);
        return new ResponseEntity<>("submitted successfull", HttpStatus.OK);}

    @Override
    public ResponseEntity<List<TSAnswer>> getAllTSAnswer() {
        logger.info("Get All TSAnswer Successfully");
        return ResponseEntity.ok(tsAnswerRepository.findAll());}
    @Override
    public ResponseEntity<Optional<TSAnswer>> getByTSAnswer(UUID id) {
        logger.info("Get TSAnswer Successfully");
        return ResponseEntity.ok(tsAnswerRepository.findById(id)); }


}
