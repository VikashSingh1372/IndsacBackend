package com.unicorn.indsaccrm.practiceresource.tsquestion;
import com.unicorn.indsaccrm.practiceresource.answer.TSAnswerImpl;
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
public class TSQuestionImpl implements TSQuestionService {
    Logger logger = LoggerFactory.getLogger(TSAnswerImpl.class);

    @Autowired
    TSQuestionRepository tSQuestionRepository;
    @Override
    public ResponseEntity<?> saveService(TSQuestion request ) {
        tSQuestionRepository.save(request);
        return new ResponseEntity<>("Submitted successfully",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TSQuestion>> getAllTSQuestion() {
        logger.info("Get ALL TsQuestion Successfully");
        return  ResponseEntity.ok(tSQuestionRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<TSQuestion>> getByTSQuestion(UUID id) {
        logger.info("Get By TsQuestion Successfully");
        return ResponseEntity.ok(tSQuestionRepository.findById(id));
    }

/*
    @Override
    public ResponseEntity<List<TSQuestion>> getAllTSQuestion() {
        logger.info("Get All TS Question successfully");
        return ResponseEntity.ok(tSQuestionRepository.findAll());
    }
    @Override
    public ResponseEntity<Optional<TSQuestion>> getByTSQuestion(UUID id) {
        logger.info("Get By TS Question Successfully");
    //    return ResponseEntity.ok(tSQuestionRepository.findById(Id));
         return   ResponseEntity.ok(tSQuestionRepository.findById(id));
    }
 */

}