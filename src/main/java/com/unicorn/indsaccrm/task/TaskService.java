package com.unicorn.indsaccrm.task;

import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface TaskService {

    ResponseEntity<?>saveAllTask(Task task);

    ResponseEntity<List<Task>>getAllTask();

    ResponseEntity<Optional<Task>>getByIdtask(UUID id);

    ResponseEntity<List<Task>> getTaskByCustomerId(UUID id);

    ResponseEntity<List<Task>> getTaskByUserAdminId(UUID id);

}
