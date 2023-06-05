package com.unicorn.indsaccrm.practiceresource.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/testseriescategory")
public class TestSeriesCategoryController {
    @Autowired
    TestSeriesCategoryService testSeriesCategoryService;
    @PostMapping
    ResponseEntity<?>createAuthenticationToken(@RequestBody TestSeriesCategory testSeriesCategory)throws Exception{
        return ResponseEntity.ok(testSeriesCategoryService.savecategory(testSeriesCategory));
    }
    @GetMapping("/all")
    public ResponseEntity<?>getAllTestSeriesCategory()throws Exception{
        return ResponseEntity.ok(testSeriesCategoryService.getAllTestSeries());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getByQuestionSeriesId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(testSeriesCategoryService.getByTestSeriesId(id));}

}
