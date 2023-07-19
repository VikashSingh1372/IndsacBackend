package com.unicorn.indsaccrm.Invoice.Payments;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentsService {

    ResponseEntity<?> savePayments(Payments payments);

    ResponseEntity<Optional<Payments>> getPaymentsById(UUID id);

    ResponseEntity<List<Payments>> getAllPayments();

    ResponseEntity<List<Payments>> getPaymentsByInvoice_id(UUID id);
}
