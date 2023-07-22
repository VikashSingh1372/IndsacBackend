package com.unicorn.indsaccrm.defaultvalues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/defaultvalues")
public class DefaultValuesController {
    @Autowired
    DefaultValuesService defaultValuesService;
    @PostMapping
    ResponseEntity<?>createAuthenticationToken(@RequestBody DefaultValues defaultValues) throws  Exception{
        return defaultValuesService.saveAllValues(defaultValues);
    }
    @GetMapping("/all")
    ResponseEntity<?>getAllMathodes()throws Exception{
        return defaultValuesService.getAllValue();
    }
    @GetMapping("/{id}")
    ResponseEntity<?>getByIDVlues(@PathVariable UUID id) throws  Exception{
        return defaultValuesService.getByIdValues(id);
    }
}
