package com.unicorn.indsaccrm.common.tickets;

import com.unicorn.indsaccrm.common.exception.ResourceNotFoundException;
import com.unicorn.indsaccrm.common.util.storage.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketsServiceImpl implements TicketsService {

    Logger logger = LoggerFactory.getLogger(Tickets.class);

    @Autowired
    TicketsRepository ticketsRepository;

    @Autowired
    FileService fileService;

    @Override
    public ResponseEntity<?> saveTicket(Tickets request,MultipartFile file) {
        request.setUploadfile(file!=null?fileService.storeFile(file):null);
        request.setTicketnumber(System.currentTimeMillis());
        return new ResponseEntity<>( ticketsRepository.save(request),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Tickets>> getAllTickets() {
        logger.info("getting successfully");
        return ResponseEntity.ok(ticketsRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Tickets>> getById(UUID id) {
        logger.info("getting by id");
        return ResponseEntity.ok(ticketsRepository.findById(id));
    }

    @Override
    public ResponseEntity<Optional<Tickets>> updateTicket(UUID id) {
        logger.info("updated successfully");
        return ResponseEntity.ok(ticketsRepository.findById(id));
    }

    @Override
    public ResponseEntity<?> deleteTicket(Tickets tickets) {
        ticketsRepository.findById(tickets.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Ticket Not found"));
        ticketsRepository.delete(tickets);
        return ResponseEntity.ok ("Deleted Successfully");
    }


    @Override
    public ResponseEntity<String> uploadTicketFile(UUID ticketId, MultipartFile ticketfile) {
        if (ticketfile.isEmpty()){
            ResponseEntity.badRequest().body("File is Empty");
        }
        Tickets tickets = ticketsRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket Not found"));
        String uploadedFileName = fileService.storeFile(ticketfile);
        if(tickets.getUploadfile()!=null){
            tickets.setUploadfile(tickets.getUploadfile()+","+uploadedFileName);
        }else{
            tickets.setUploadfile(uploadedFileName);
        }
        ticketsRepository.save(tickets);
        return ResponseEntity.ok().body(uploadedFileName);
    }

    @Override
    public ResponseEntity<Resource> getFile(UUID ticketId, String fileName) throws IOException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(fileService.getFile(fileName));
    }
}
