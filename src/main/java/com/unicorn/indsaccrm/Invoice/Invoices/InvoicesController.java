package com.unicorn.indsaccrm.Invoice.Invoices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/invoices")
public class InvoicesController {

    @Autowired
    InvoicesService invoicesService;

    @PostMapping
    ResponseEntity<?> saveInvoices(@RequestBody Invoices invoices)throws Exception {
        return ResponseEntity.ok(invoicesService.saveInvoices(invoices));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllInvoices()throws Exception {
        return ResponseEntity.ok(invoicesService.getAllInvoices());
    }

    //primary key
    @GetMapping("/{id}")
    ResponseEntity<?> getInvoicesById(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(invoicesService.getInvoicesById(id));
    }

    @GetMapping("/Customer_id/{id}")
    ResponseEntity<?> getInvoicesByCustomer_id(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(invoicesService.getInvoicesByCustomer_id(id));
    }

    @GetMapping("/User_id/{id}")
    ResponseEntity<?> getInvoicesByUser_id(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(invoicesService.getInvoicesByUser_id(id));
    }

}
