package com.unicorn.indsaccrm.lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/lead")
public class LeadController {
    @Autowired
    LeadService leadService;
    @PostMapping
    ResponseEntity<?>createAuthenticationToken (@RequestBody Lead lead)throws  Exception{
        return ResponseEntity.ok(leadService.SaveAllLead(lead));
    }
    @GetMapping("/all")
    ResponseEntity<?>saveAllLeads()throws Exception{
        return ResponseEntity.ok(leadService.getAllLead());
    }
    @GetMapping("/{id}")
    ResponseEntity<?>getByIDLeads(@PathVariable UUID id)throws Exception{
        return ResponseEntity.ok(leadService.getByIdLead(id));
    }
}
