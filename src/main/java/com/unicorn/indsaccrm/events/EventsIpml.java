package com.unicorn.indsaccrm.events;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class EventsIpml implements EventsService{
    @Autowired
    EventsRepository eventsRepository;

    Logger logger=LoggerFactory.logger(EventsIpml.class);
    @Override
    public ResponseEntity<?> saveAllEvent(Events request) {
        eventsRepository.save(request);
        return new ResponseEntity<>("save successfuly event", HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<List<Events>> getAllEvent() {
        logger.info("get all event");
        return ResponseEntity.ok(eventsRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Events>> getByIdEvent(UUID id) {
        logger.info("get events by id");
        return ResponseEntity.ok(eventsRepository.findById(id));
    }
}
