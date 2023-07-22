package com.unicorn.indsaccrm.Invoice.Invoices;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvoicesService {

    ResponseEntity<?> saveInvoices(Invoices invoices);

    ResponseEntity<List<Invoices>> getAllInvoices();

    ResponseEntity<Optional<Invoices>> getInvoicesByInvoiceId(UUID invoiceid);

    ResponseEntity<List<Invoices>> getInvoicesByCustomerId(UUID id);

    ResponseEntity<List<Invoices>> getInvoicesByUserId(UUID id);
}
