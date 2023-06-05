package com.unicorn.indsaccrm.practiceresource.category;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class TestSeriesCategoryImpl implements TestSeriesCategoryService{
    Logger loggertest= LoggerFactory.getLogger(TestSeriesCategoryImpl.class);
    @Autowired
    TestSeriesCategoryRepository testSeriesCategoryRepository;
    @Override
    public ResponseEntity<?> savecategory(TestSeriesCategory testSeriesCategory) {
        testSeriesCategoryRepository.save(testSeriesCategory);
        return new ResponseEntity<>("Submmited successfull",HttpStatus.OK);
    }
    @Override
    public ResponseEntity<List<TestSeriesCategory>> getAllTestSeries() {
        loggertest.info("get All Test Successfully");
        return ResponseEntity.ok(testSeriesCategoryRepository.findAll());
    }
    @Override
    public ResponseEntity<Optional<TestSeriesCategory>> getByTestSeriesId(UUID id) {
        loggertest.info("Get  by Test Successfully");
        return   ResponseEntity.ok(testSeriesCategoryRepository.findById(id));
    }

}
