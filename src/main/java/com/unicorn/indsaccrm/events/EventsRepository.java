package com.unicorn.indsaccrm.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface EventsRepository extends JpaRepository<Events, UUID> {
}
