package com.unicorn.indsaccrm.emailsetting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/emailsetting")
public class EmailSettingController {
    @Autowired
    EmailSettingService emailSettingService;
    @PostMapping
    ResponseEntity<?>createAuthenticationToken(@RequestBody EmailSetting emailSetting)throws Exception{
        return ResponseEntity.ok(emailSettingService.saveAllEmail(emailSetting));
    }
    @GetMapping("/all")
    ResponseEntity<?>getAllEmailSetting()throws Exception{
        return ResponseEntity.ok(emailSettingService.getAllEmail());
    }
    @GetMapping("/{id}")
    ResponseEntity<?>getByIdEmailSetting(@PathVariable UUID id)throws Exception{
        return ResponseEntity.ok(emailSettingService.getByIdEmail(id));
    }
}
