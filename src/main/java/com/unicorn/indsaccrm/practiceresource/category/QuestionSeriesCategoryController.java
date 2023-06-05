package com.unicorn.indsaccrm.practiceresource.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/questioncategory")
public class QuestionSeriesCategoryController {
    @Autowired
    QuestionSeriesCategoryService questionSeriesCategoryService;
    @PostMapping
    ResponseEntity<?>createAuthenticationToken(@RequestBody QuestionSeriesCategory requestque)throws Exception{
        return ResponseEntity.ok(questionSeriesCategoryService.savequecate(requestque));
    }
    @GetMapping("/all")
    public ResponseEntity<?>getAlluestionSeriesCategory()throws Exception{
        return ResponseEntity.ok(questionSeriesCategoryService.getAllQuestionSeries());
    }
//    @GetMapping("{id}")
//    public ResponseEntity<?>getByuestionSeriesCategoryId()throws Exception{
//        return ResponseEntity.ok(questionSeriesCategoryService.getbyQuestionSeriesId(id));
//    }
@GetMapping("/{id}")
public ResponseEntity<?> getByQuestionSeriesId(@PathVariable UUID id) throws Exception {
    return ResponseEntity.ok(questionSeriesCategoryService.getByQuestionSeriesId(id));
}

}
