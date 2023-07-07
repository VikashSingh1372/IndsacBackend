package com.unicorn.indsaccrm.task;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface TaskService {

    ResponseEntity<?>saveAllTask(Task task);

    ResponseEntity<List<Task>>getAllTask();

    ResponseEntity<Optional<Task>>getByIdtask(UUID id);

}
