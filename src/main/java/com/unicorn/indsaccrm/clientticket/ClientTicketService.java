package com.unicorn.indsaccrm.clientticket;
import com.unicorn.indsaccrm.admindefaultvalues.AdminDefaultValues;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientTicketService {
    ResponseEntity<?> saveClientTicket(ClientTicket values);

    ResponseEntity<List<ClientTicket>> getAllClientTickets();

    ResponseEntity<Optional<ClientTicket>> getByClientTicketId(UUID id);
}
