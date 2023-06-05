package com.unicorn.indsaccrm.practiceresource.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tsanswer")
public class TSAnswerController {
    @Autowired
    TSAnswerService tsAnswerService;

    @PostMapping
    ResponseEntity<?>createAuthenticationToken(@RequestBody TSAnswer requestans)throws Exception{
        return ResponseEntity.ok(tsAnswerService.saveanswer(requestans));
    }

  @GetMapping("/all")
    public ResponseEntity<?> getAllTSAnswer() throws Exception {
        return ResponseEntity.ok(tsAnswerService.getAllTSAnswer());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getByTSAnswerId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(tsAnswerService.getByTSAnswer(id));}

}
