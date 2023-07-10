package com.unicorn.indsaccrm.common.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/ticket")
public class TicketsController {
    @Autowired
    TicketsService ticketsService;
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
    ResponseEntity<?>saveTicket(@RequestBody Tickets tickets,@RequestParam(name = "file", required = false)
            MultipartFile file)throws Exception{
        return  ResponseEntity.ok(ticketsService.saveTicket(tickets,file));
    }
    @GetMapping("/all")
    ResponseEntity<?>getAllTickets()throws  Exception{
        return ResponseEntity.ok(ticketsService.getAllTickets());
    }
    @GetMapping("{id}")
    ResponseEntity<?>getById(@PathVariable UUID id)throws Exception{
        return ResponseEntity.ok(ticketsService.getById(id));
    }
    @PutMapping("{id}")
    ResponseEntity<?>updateTicket(@PathVariable UUID id ,@RequestBody Tickets tickets)throws Exception{
        Tickets newupdate= ticketsService.getById(id).getBody().orElse(null);
        if(newupdate==null){
            return ResponseEntity.notFound().build();
        }else {
            newupdate.setUserid(tickets.getUserid());
            newupdate.setAssigned(tickets.getAssigned());
            newupdate.setUploadfile(tickets.getUploadfile());
            newupdate.setTitle(tickets.getTitle());
            newupdate.setDescription(tickets.getDescription());
            newupdate.setStatus(tickets.getStatus());
            newupdate.setPriority(tickets.getPriority());
            newupdate.setTicketnumber(tickets.getTicketnumber());
        }
        ticketsService.saveTicket(newupdate,null);
        return new ResponseEntity<>("successfully updated",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?>deletebyid(@PathVariable UUID id)throws Exception{
        Tickets deleteone= ticketsService.getById(id).getBody().orElse(null);
        if(deleteone==null){
            return ResponseEntity.notFound().build();
        }
        ticketsService.deleteTicket(deleteone);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }
    @PostMapping("/upload/{ticketId}")
    public ResponseEntity<String> uploadFile(@PathVariable UUID ticketId,@RequestParam(name = "file", required = false)
    MultipartFile file) {
        if (file == null) {
            return ResponseEntity.badRequest().body("No file provided");
        }
        try {
            String ticketfileName = String.valueOf(ticketsService.uploadTicketFile(ticketId,file));
            return ResponseEntity.ok().body(ticketfileName);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
        }
    }

    @GetMapping("/file/{ticketId}/{filename}")
    public ResponseEntity<Resource> getFile(@PathVariable UUID ticketId, @PathVariable String filename) throws IOException {
        return ticketsService.getFile(ticketId,filename);
    }
}
