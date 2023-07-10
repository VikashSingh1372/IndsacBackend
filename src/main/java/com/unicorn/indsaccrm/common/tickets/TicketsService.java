package com.unicorn.indsaccrm.common.tickets;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TicketsService {
    ResponseEntity<?> saveTicket(Tickets request, MultipartFile file);
    ResponseEntity<List<Tickets>> getAllTickets();
   ResponseEntity<Optional<Tickets>>getById(UUID id);
   ResponseEntity<Optional<Tickets>> updateTicket(UUID id);
   ResponseEntity<?> deleteTicket(Tickets tickets);
    ResponseEntity<String> uploadTicketFile(UUID ticketId, MultipartFile file);

    ResponseEntity<Resource> getFile(UUID ticketId, String fileName) throws IOException;
}
