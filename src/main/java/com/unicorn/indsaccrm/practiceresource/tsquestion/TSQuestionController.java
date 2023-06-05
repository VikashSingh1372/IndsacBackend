package com.unicorn.indsaccrm.practiceresource.tsquestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tsquestion")
public class TSQuestionController {
    @Autowired
    private TSQuestionService tSQuestionService;
            @PostMapping
        //@RequestMapping(name = "/post",method = RequestMethod.POST)
     public ResponseEntity<?>createAuthenticationToken(@RequestBody TSQuestion request)throws Exception {
                return ResponseEntity.ok(tSQuestionService.saveService(request));
            }
    @GetMapping("/all")
    public ResponseEntity<?> getAllTSQuestion() throws Exception {
        return ResponseEntity.ok(tSQuestionService.getAllTSQuestion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByCourseId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(tSQuestionService.getByTSQuestion(id));
    }



/*
    @GetMapping("/all")
    ResponseEntity<?>geAllTSQuestion()throws Exception{
            return ResponseEntity.ok(tSQuestionService.getAllTSQuestion()); }
    @GetMapping("{id}")
    public ResponseEntity<?>getByQuestionId(@PathVariable UUID id)throws Exception{
            return ResponseEntity.ok(tSQuestionService.getByTSQuestion(id));
    }
 */

}