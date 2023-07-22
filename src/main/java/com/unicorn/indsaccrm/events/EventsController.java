package com.unicorn.indsaccrm.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/events")
public class EventsController {
    @Autowired
    EventsService eventsService;
    @PostMapping
    ResponseEntity<?>createAuthenticationToken(@RequestBody Events events)throws Exception{
        return ResponseEntity.ok(eventsService.saveAllEvent(events));
    }
    @GetMapping("/all")
    ResponseEntity<?>getAllEvent()throws Exception{
        return ResponseEntity.ok(eventsService.getAllEvent());
    }
    @GetMapping("{id}")
    ResponseEntity<?>getEventByID(@PathVariable UUID id)throws Exception{
        return ResponseEntity.ok(eventsService.getByIdEvent(id));
    }
}
