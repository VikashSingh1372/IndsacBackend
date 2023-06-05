package com.unicorn.indsaccrm.practiceresource.testseries;


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
public class TestSeriesImpl implements TestSeriesService{
    @Autowired
    TestSeriesRepository testSeriesRepository;
    Logger logger = LoggerFactory.getLogger(TestSeriesImpl.class);

    @Override
    public ResponseEntity<?> savetest(TestSeries testrequest) {
        testSeriesRepository.save(testrequest);
        return new ResponseEntity<>("Submited successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TestSeries>> getAllTestSeries() {
        logger.info("Get All Answer Successfully");
        return ResponseEntity.ok(testSeriesRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<TestSeries>> getByTestSeriesId(UUID Id) {
        logger.info("Get Answer Successfully");
        return ResponseEntity.ok(testSeriesRepository.findById(Id));
    }


}
