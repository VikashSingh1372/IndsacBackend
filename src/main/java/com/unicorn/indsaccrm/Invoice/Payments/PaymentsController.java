package com.unicorn.indsaccrm.Invoice.Payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/payment")
public class PaymentsController {

    @Autowired
    PaymentsService paymentsService;

    @PostMapping
    ResponseEntity<?> savePayments(@RequestBody Payments payments) throws Exception{
        return ResponseEntity.ok(paymentsService.savePayments(payments));
    }

    @GetMapping("/{paymentid}")
    ResponseEntity<?> getPaymentById(@PathVariable UUID paymentid) throws Exception{
        return ResponseEntity.ok(paymentsService.getPaymentsByPaymentId(paymentid));
    }

    @GetMapping("/all")
    ResponseEntity<?> gealltPayments() throws Exception{
        return ResponseEntity.ok(paymentsService.getAllPayments());
    }

    @GetMapping("/invoiceid/{invoiceid}")
    ResponseEntity<?> getPaymentByInvoice_id(@PathVariable UUID invoiceid) throws Exception{
        return ResponseEntity.ok(paymentsService.getPaymentsByInvoiceId(invoiceid));
    }
}
