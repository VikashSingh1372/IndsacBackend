package com.unicorn.indsaccrm.clientticket;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientTicketRepository extends JpaRepository<ClientTicket,UUID> {
}
