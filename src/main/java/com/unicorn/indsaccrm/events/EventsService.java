package com.unicorn.indsaccrm.events;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventsService {
    ResponseEntity<?> saveAllEvent(Events request);
    ResponseEntity<List<Events>> getAllEvent();
    ResponseEntity<Optional<Events>> getByIdEvent(UUID id);
}
