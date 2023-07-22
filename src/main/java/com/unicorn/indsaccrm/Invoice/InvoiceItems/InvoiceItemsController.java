package com.unicorn.indsaccrm.Invoice.InvoiceItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/invoiceitems")
public class InvoiceItemsController {
    @Autowired
    InvoiceItemsService invoiceItemsService;

    @PostMapping
    ResponseEntity<?> saveInvoiceItems(@RequestBody InvoiceItems invoiceItems) throws Exception{
      return ResponseEntity.ok(invoiceItemsService.saveInvoiceItem(invoiceItems));
    }

   @GetMapping("/all")
   ResponseEntity<?> getAllInvoiceItems() throws Exception {
       return ResponseEntity.ok(invoiceItemsService.getallInvoiceItems());
   }

   @GetMapping("/{itemid}")
    ResponseEntity<?> getInvoiceItemsById(@PathVariable UUID itemid) throws Exception {
       return ResponseEntity.ok(invoiceItemsService.getInvoiceItemByItemId(itemid));
   }

    @GetMapping("/Invoiceid/{id}")
    ResponseEntity<?> getInvoiceItemsByInvoiceid(@PathVariable UUID id) throws  Exception {
        return ResponseEntity.ok(invoiceItemsService.getInvoiceItemByInvoiceid(id));
    }

    @GetMapping("/Productid/{id}")
    ResponseEntity<?> getInvoiceItemsByProductid(@PathVariable UUID id) throws  Exception {
        return ResponseEntity.ok(invoiceItemsService.getInvoiceItemByProductid(id));
    }
}
