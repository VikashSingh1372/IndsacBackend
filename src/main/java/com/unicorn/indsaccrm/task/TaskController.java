package com.unicorn.indsaccrm.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @PostMapping
    ResponseEntity<?>createTask(@RequestBody Task task)throws Exception{
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

    @GetMapping("/customerid/{id}")
    ResponseEntity<?> getTaskByCustomerId(@PathVariable UUID id)throws  Exception{
        return ResponseEntity.ok(taskService.getTaskByCustomerId(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getTaskByUserAdminId(@PathVariable UUID id)throws  Exception{
        return ResponseEntity.ok(taskService.getTaskByUserAdminId(id));
    }
}
