package com.unicorn.indsaccrm.Invoice.Invoices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/invoice")
public class InvoicesController {

    @Autowired
    InvoicesService invoicesService;

    @PostMapping
    ResponseEntity<?> saveInvoices(@RequestBody Invoice invoice)throws Exception {
        return ResponseEntity.ok(invoicesService.saveInvoices(invoice));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllInvoices()throws Exception {
        return ResponseEntity.ok(invoicesService.getAllInvoices());
    }

    //primary key
    @GetMapping("/{invoiceid}")
    ResponseEntity<?> getInvoicesById(@PathVariable UUID invoiceid)throws Exception {
        return ResponseEntity.ok(invoicesService.getInvoicesByInvoiceId(invoiceid));
    }

    @GetMapping("/Customerid/{id}")
    ResponseEntity<?> getInvoicesByCustomerId(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(invoicesService.getInvoicesByCustomerId(id));
    }

    @GetMapping("/Userid/{id}")
    ResponseEntity<?> getInvoicesByUser_id(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(invoicesService.getInvoicesByUserId(id));
    }

}
