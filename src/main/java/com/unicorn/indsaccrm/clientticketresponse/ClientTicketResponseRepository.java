package com.unicorn.indsaccrm.clientticketresponse;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientTicketResponseRepository extends JpaRepository<ClientTicketResponse, UUID> {
}
