package com.unicorn.indsaccrm.Invoice.InvoiceItems;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvoiceItemsService {

    ResponseEntity<?> saveInvoiceItem(InvoiceItems invoiceItems);

    ResponseEntity<List<InvoiceItems>> getallInvoiceItems();

    ResponseEntity<Optional<InvoiceItems>> getInvoiceItemByItemId(UUID itemid);

    ResponseEntity<List<InvoiceItems>> getInvoiceItemByInvoiceid(UUID id);

    ResponseEntity<List<InvoiceItems>> getInvoiceItemByProductid(UUID id);
}
