package com.unicorn.indsaccrm.clientticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clientticket")
public class ClientTicketController {

    @Autowired
    ClientTicketService clientTicketService;



    @PostMapping
    public ResponseEntity<?> ClientTicket(@RequestBody ClientTicket values) throws Exception {
        return ResponseEntity.ok(clientTicketService.saveClientTicket(values));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllClientTickets() throws Exception {
        return ResponseEntity.ok(clientTicketService.getAllClientTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByClentTcketId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(clientTicketService.getByClientTicketId(id));
    }
}
