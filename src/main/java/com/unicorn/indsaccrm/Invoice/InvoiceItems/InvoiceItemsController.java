package com.unicorn.indsaccrm.Invoice.InvoiceItems;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@AllArgsConstructor
public class InvoiceItemsController {


   InvoiceItemsService invoiceItemsService;

   @PostMapping
   ResponseEntity<?> saveInvoiceItems(@RequestBody InvoiceItems invoiceItems) throws Exception{
       return ResponseEntity.ok(invoiceItemsService.saveInvoiceItem(invoiceItems));
   }

   @GetMapping("/all")
   ResponseEntity<?> getAllInvoiceItems() throws Exception {
       return ResponseEntity.ok(invoiceItemsService.getallInvoiceItems());
   }

   @GetMapping("/{id}")
    ResponseEntity<?> getInvoiceItemsById(@PathVariable UUID id) throws Exception {
       return ResponseEntity.ok(invoiceItemsService.getInvoiceItemById(id));
   }

    @GetMapping("/Invoice_id/{id}")
    ResponseEntity<?> getInvoiceItemsByInvoice_id(@PathVariable UUID id) throws  Exception {
        return ResponseEntity.ok(invoiceItemsService.getInvoiceItemByInvoice_id(id));
    }

    @GetMapping("/Product_id/{id}")
    ResponseEntity<?> getInvoiceItemsByProduct_id(@PathVariable UUID id) throws  Exception {
        return ResponseEntity.ok(invoiceItemsService.getInvoiceItemByProduct_id(id));
    }
}
