package com.unicorn.indsaccrm.Invoice.InvoiceItems;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvoiceItemsService {

    ResponseEntity<?> saveInvoiceItem(InvoiceItems invoiceItems);

    ResponseEntity<List<InvoiceItems>> getallInvoiceItems();

    ResponseEntity<Optional<InvoiceItems>> getInvoiceItemById(UUID id);

    ResponseEntity<List<InvoiceItems>> getInvoiceItemByInvoice_id(UUID id);

    ResponseEntity<List<InvoiceItems>> getInvoiceItemByProduct_id(UUID id);
}
