package com.unicorn.indsaccrm.practiceresource.category;
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
public class QuestionSeriesCategoryImpl implements QuestionSeriesCategoryService{
    @Autowired
    QuestionSeriesCategoryRepository questionSeriesCategoryRepository;
    Logger loggerquestion = LoggerFactory.getLogger(QuestionSeriesCategoryImpl.class);

    @Override
    public ResponseEntity<?> savequecate(QuestionSeriesCategory requestque) {
        questionSeriesCategoryRepository.save(requestque);
        return new ResponseEntity<>("Submmited successfully", HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<List<QuestionSeriesCategory>> getAllQuestionSeries() {
        loggerquestion.info("get All QuestionSeries Successfully");
        return ResponseEntity.ok(questionSeriesCategoryRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<QuestionSeriesCategory>> getByQuestionSeriesId(UUID id) {
        loggerquestion.info("Get  by QuestionSeries Successfully");
        return   ResponseEntity.ok(questionSeriesCategoryRepository.findById(id));
    }
/*
    @Override
    public ResponseEntity<Optional<QuestionSeriesCategory>> getbyQuestionSeriesId(UUID id) {
        logger1.info("get By QuestionSeriesId Successfully");
        return ResponseEntity.ok(questionSeriesCategoryRepository.findById(id));
    }
@Override
public ResponseEntity<Optional<QuestionSeriesCategory>> getbyQuestionSeriesId(UUID id) {
    logger1.info("get By QuestionSeriesId Successfully");
    return ResponseEntity.ok(questionSeriesCategoryRepository.findById(id));
}
 */


}
