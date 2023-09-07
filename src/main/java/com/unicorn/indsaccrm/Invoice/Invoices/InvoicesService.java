package com.unicorn.indsaccrm.Invoice.Invoices;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvoicesService {

    ResponseEntity<?> saveInvoices(Invoice invoice);

    ResponseEntity<List<Invoice>> getAllInvoices();

    ResponseEntity<Optional<Invoice>> getInvoicesByInvoiceId(UUID invoiceid);

    ResponseEntity<List<Invoice>> getInvoicesByCustomerId(UUID id);

    ResponseEntity<List<Invoice>> getInvoicesByUserId(UUID id);
}
