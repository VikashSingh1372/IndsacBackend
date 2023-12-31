package com.unicorn.indsaccrm.clientticketresponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientTicketResponseService {
    ResponseEntity<?> saveClientTicketResponse(ClientTicketResponse values);

    ResponseEntity<List<ClientTicketResponse>> getAllClientTicketResponses();

    ResponseEntity<Optional<ClientTicketResponse>> getByClientTicketResponseId(UUID id);

    ResponseEntity<List<ClientTicketResponse>> getClientTicketResponsesByCustomerId(UUID customerId);

    ResponseEntity<List<ClientTicketResponse>> getClientTicketResponsesByUsercid(UUID usercid);

    ResponseEntity<List<ClientTicketResponse>> getClientTicketResponseByUseradminid(UUID useradminid);
}
