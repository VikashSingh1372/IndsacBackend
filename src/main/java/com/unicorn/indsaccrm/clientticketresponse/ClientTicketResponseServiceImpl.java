package com.unicorn.indsaccrm.clientticketresponse;

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
public class ClientTicketResponseServiceImpl implements ClientTicketResponseService{

    Logger logger = LoggerFactory.getLogger(ClientTicketResponseServiceImpl.class);

    @Autowired
    ClientTicketResponseRepository clientTicketResponseRepository;
    @Override
    public ResponseEntity<?> saveClientTicketResponse(ClientTicketResponse request) {
        logger.info("ClientTicketResponse Saved Successfully");
        return new ResponseEntity<>(clientTicketResponseRepository.save(request),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ClientTicketResponse>> getAllClientTicketResponses() {
        logger.info("Get ALL ClientTicketResponses Successfully");
        return ResponseEntity.ok(clientTicketResponseRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<ClientTicketResponse>> getByClientTicketResponseId(UUID id) {
        logger.info("Get ClientTicketResponse Successfully");
        return  ResponseEntity.ok(clientTicketResponseRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<ClientTicketResponse>> getClientTicketResponsesByCustomerId(String customerId) {
        logger.info("Get ClientTicketResponses By CustomerId Successfully");
        return ResponseEntity.ok(clientTicketResponseRepository.findByCustomerid(customerId));
    }

    @Override
    public ResponseEntity<List<ClientTicketResponse>> getClientTicketResponsesByUsercid(String usercid) {
        logger.info("Get ClientTicketResponses By usercid Successfully");
        return ResponseEntity.ok(clientTicketResponseRepository.findByUsercid(usercid));
    }
}
