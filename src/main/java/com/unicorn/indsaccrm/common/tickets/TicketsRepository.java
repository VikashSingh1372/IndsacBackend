package com.unicorn.indsaccrm.common.tickets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface TicketsRepository extends JpaRepository<Tickets, UUID> {
}
