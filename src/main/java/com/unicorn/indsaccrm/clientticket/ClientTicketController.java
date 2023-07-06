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
    public ResponseEntity<?> getClientTicketById(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(clientTicketService.getByClientTicketId(id));
    }

    @GetMapping("/entercustomerid/{id}")
    public ResponseEntity<?> getClientTicketByCustomerId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(clientTicketService.getClientTicketsByCustomerid(id));
    }

    @GetMapping("/enterusercid/{id}")
    public ResponseEntity<?> getClientTicketByUsercid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(clientTicketService.getClientTicketByUsercid(id));
    }

    @GetMapping("/enteruseradminid/{id}")
    public ResponseEntity<?> getClientTicketByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(clientTicketService.getClientTicketByUseradminid(id));
    }
}
