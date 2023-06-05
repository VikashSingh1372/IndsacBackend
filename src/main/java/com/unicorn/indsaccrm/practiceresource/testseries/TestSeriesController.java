package com.unicorn.indsaccrm.practiceresource.testseries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
@RequestMapping("/testseries")
public class TestSeriesController {
    @Autowired
   private TestSeriesService testSeriesService;
    @PostMapping
    ResponseEntity<?>createAuthenticationToken(@RequestBody TestSeries testrequest)throws Exception{
        testSeriesService.savetest(testrequest);
        return ResponseEntity.ok(testSeriesService.savetest(testrequest));
    }
    @GetMapping("/all")
    public ResponseEntity<?>getAllTestSeries()throws Exception{
        return ResponseEntity.ok(testSeriesService.getAllTestSeries());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>getByTestSeriesId(@PathVariable UUID id) throws Exception{
        return ResponseEntity.ok(testSeriesService.getByTestSeriesId(id));
    }
}
