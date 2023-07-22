package com.unicorn.indsaccrm.Invoice.Payments;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentsService {

    ResponseEntity<?> savePayments(Payments payments);

    ResponseEntity<Optional<Payments>> getPaymentsByPaymentId(UUID id);

    ResponseEntity<List<Payments>> getAllPayments();

    ResponseEntity<List<Payments>> getPaymentsByInvoiceId(UUID invoiceid);
}
