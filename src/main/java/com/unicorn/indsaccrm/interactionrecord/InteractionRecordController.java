package com.unicorn.indsaccrm.interactionrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Controller
@RequestMapping("/interactionrecord")
public class InteractionRecordController {
    @Autowired
    InteractionRecordService interactionRecordService;

    @PostMapping
    ResponseEntity<?>createAuthenticationToken(@RequestBody InteractionRecord interactionRecord)throws Exception{
        return ResponseEntity.ok(interactionRecordService.saveAllInteraction(interactionRecord));
    }
    @GetMapping("/all")
    ResponseEntity<?>SaveAllintractionRecord()throws Exception{
        return  ResponseEntity.ok(interactionRecordService.getAllInteraction());
    }
    @GetMapping("/{id}")
    ResponseEntity<?>getByid(@PathVariable UUID id)throws Exception{
        return ResponseEntity.ok(interactionRecordService.getByIdInteraction(id));
    }
    @GetMapping("/customerid/{id}")
    ResponseEntity<?>getByCustomerId(@PathVariable UUID id)throws Exception{
        return ResponseEntity.ok(interactionRecordService.getInteractionRecordByCustomerId(id));
    }

    @GetMapping("/userAdminId/{id}")
    ResponseEntity<?>getByUserAdminId(@PathVariable UUID id)throws Exception{
        return ResponseEntity.ok(interactionRecordService.getInteractionRecordByUserAdminId(id));
    }
}
