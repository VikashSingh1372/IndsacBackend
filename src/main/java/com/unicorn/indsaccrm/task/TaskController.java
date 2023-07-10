package com.unicorn.indsaccrm.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @PostMapping
    ResponseEntity<?>createAuthenticationToken(@RequestBody Task task)throws Exception{
        return ResponseEntity.ok(taskService.saveAllTask(task));
    }
    @GetMapping("/all")
    ResponseEntity<?>getAlltasks()throws Exception{
        return ResponseEntity.ok(taskService.getAllTask());
    }
    @GetMapping("/{id}")
    ResponseEntity<?>getByIdtaks(@PathVariable UUID id)throws  Exception{
        return ResponseEntity.ok(taskService.getByIdtask(id));
    }
}
