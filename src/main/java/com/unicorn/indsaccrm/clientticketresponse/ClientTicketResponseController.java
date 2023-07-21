package com.unicorn.indsaccrm.clientticketresponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/clientticketresponse")
public class ClientTicketResponseController {

    @Autowired
    ClientTicketResponseService clientTicketResponseService;

    @PostMapping
    public ResponseEntity<?> ClientTicketResponse(@RequestBody ClientTicketResponse values) throws Exception {
        return ResponseEntity.ok(clientTicketResponseService.saveClientTicketResponse(values));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllClientTicketResponses() throws Exception {
        return ResponseEntity.ok(clientTicketResponseService.getAllClientTicketResponses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByClientTicketResponseId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(clientTicketResponseService.getByClientTicketResponseId(id));
    }

    @GetMapping("/entercustomerid/{id}")
    public ResponseEntity<?> getClientTicketResponseByCustomerId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(clientTicketResponseService.getClientTicketResponsesByCustomerId(id));
    }

    @GetMapping("/enterusercid/{id}")
    public ResponseEntity<?> getClientTicketResponseByUsercId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(clientTicketResponseService.getClientTicketResponsesByUsercid(id));
    }

    @GetMapping("/enteruseradminid/{id}")
    public ResponseEntity<?> getClientTicketResponseByUseradminid(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(clientTicketResponseService.getClientTicketResponseByUseradminid(id));
    }
}
