package com.unicorn.indsaccrm.loginlocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/loginlocation")
public class loginlocationController {
    @Autowired
    private loginlocationService loginlocationService;
    @PostMapping
    ResponseEntity<?> createloginlocation(@RequestBody loginlocation loginlocation) throws Exception {
        return ResponseEntity.ok(loginlocationService.saveloginlocation(loginlocation));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllloginlocation() throws Exception {
        return ResponseEntity.ok(loginlocationService.getAllloginlocations());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getloginlocationByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(loginlocationService.getloginlocationById(id));
    }
}