package com.unicorn.indsaccrm.Invoice.Payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentsController {

    @Autowired
    PaymentsService paymentsService;

    @PostMapping
    ResponseEntity<?> savePayments(@RequestBody Payments payments) throws Exception{
        return ResponseEntity.ok(paymentsService.savePayments(payments));
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getPaymentById(@PathVariable UUID id) throws Exception{
        return ResponseEntity.ok(paymentsService.getPaymentsById(id));
    }

    @GetMapping("/all")
    ResponseEntity<?> getPaymentById() throws Exception{
        return ResponseEntity.ok(paymentsService.getAllPayments());
    }

    @GetMapping("/invoice_id/{id}")
    ResponseEntity<?> getPaymentByInvoice_id(@PathVariable UUID id) throws Exception{
        return ResponseEntity.ok(paymentsService.getPaymentsByInvoice_id(id));
    }
}
