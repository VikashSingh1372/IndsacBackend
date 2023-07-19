package com.unicorn.indsaccrm.Invoice.Invoices;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvoicesService {

    ResponseEntity<?> saveInvoices(Invoices invoices);

    ResponseEntity<List<Invoices>> getAllInvoices();

    ResponseEntity<Optional<Invoices>> getInvoicesById(UUID id);

    ResponseEntity<List<Invoices>> getInvoicesByCustomer_id(UUID id);

    ResponseEntity<List<Invoices>> getInvoicesByUser_id(UUID id);
}
