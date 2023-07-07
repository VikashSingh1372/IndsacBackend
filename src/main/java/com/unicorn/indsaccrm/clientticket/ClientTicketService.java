package com.unicorn.indsaccrm.clientticket;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientTicketService {
    ResponseEntity<?> saveClientTicket(ClientTicket values);

    ResponseEntity<List<ClientTicket>> getAllClientTickets();

    ResponseEntity<Optional<ClientTicket>> getByClientTicketId(UUID id);

    ResponseEntity<List<ClientTicket>> getClientTicketsByCustomerid(UUID customerid);

    ResponseEntity<List<ClientTicket>> getClientTicketByUsercid(UUID usercid);

    ResponseEntity<List<ClientTicket>> getClientTicketByUseradminid(UUID useradminid);
}
