package com.unicorn.indsaccrm.clientticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientTicketServiceImpl implements ClientTicketService{

    Logger logger = LoggerFactory.getLogger(ClientTicketServiceImpl.class);

    @Autowired
    private ClientTicketRepository clientTicketRepository;
    @Override
    public ResponseEntity<?> saveClientTicket(ClientTicket request) {
        logger.info("ClientTicket Saved Successfully");
        return  new ResponseEntity<>(clientTicketRepository.save(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ClientTicket>> getAllClientTickets() {
        logger.info("Get ALL ClientTickets Successfully");
        return  ResponseEntity.ok(clientTicketRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<ClientTicket>> getByClientTicketId(UUID id) {
        logger.info("Get ClientTicket Successfully");
        return   ResponseEntity.ok(clientTicketRepository.findById(id));
    }
}
