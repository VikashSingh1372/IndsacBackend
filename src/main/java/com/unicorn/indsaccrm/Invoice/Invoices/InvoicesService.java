package com.unicorn.indsaccrm.Invoice.Invoices;

import com.unicorn.indsaccrm.Invoice.Invoices.Invoice.InvoiceStatus;
import java.time.LocalDate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvoicesService {

    ResponseEntity<?> saveInvoices(Invoice invoice);

    ResponseEntity<List<Invoice>> getAllInvoices();

    ResponseEntity<Optional<Invoice>> getInvoicesByInvoiceId(UUID invoiceid);

    ResponseEntity<List<Invoice>> getInvoicesByCustomerId(UUID id);

    ResponseEntity<List<Invoice>> getAllInvoicesByUserAdminId(UUID useradminid);

    ResponseEntity<List<Invoice>> getAllInvoicesByDueDateAndStatusNotIn( UUID customerid,
        UUID useradminid, LocalDate duedate, List<InvoiceStatus> statuses);

    ResponseEntity<List<Invoice>> getAllInvoicesByStatusNotIn( UUID customerid,
        UUID useradminid,List<InvoiceStatus> statuses);
}
