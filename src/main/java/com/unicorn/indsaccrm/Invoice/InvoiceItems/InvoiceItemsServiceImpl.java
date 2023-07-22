package com.unicorn.indsaccrm.Invoice.InvoiceItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceItemsServiceImpl implements InvoiceItemsService {


    @Autowired
    InvoiceItemsRepository invoiceItemsRepository;

    Logger logger = LoggerFactory.getLogger(InvoiceItemsServiceImpl.class);

    @Override
    public ResponseEntity<?> saveInvoiceItem(InvoiceItems invoiceItems) {
        logger.info("save InvoiceItem inside saveInvoiceItem successfully");
        return ResponseEntity.ok(invoiceItemsRepository.save(invoiceItems));
    }

    @Override
    public ResponseEntity<List<InvoiceItems>> getallInvoiceItems() {
        logger.info("Get all InvoiceItems inside getallInvoiceItems successfully");
        return ResponseEntity.ok(invoiceItemsRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<InvoiceItems>> getInvoiceItemByItemId(UUID itemid) {
        logger.info("Get InvoiceItem By Id inside getInvoiceItemByItemId successfully");
        return ResponseEntity.ok(invoiceItemsRepository.findByItemid(itemid));
    }

    @Override
    public ResponseEntity<List<InvoiceItems>> getInvoiceItemByInvoiceid(UUID id) {
        logger.info("Get InvoiceItem By Invoice_id inside getInvoiceItemByInvoiceid successfully");
        return ResponseEntity.ok(invoiceItemsRepository.findByInvoiceid(id));
    }

    @Override
    public ResponseEntity<List<InvoiceItems>> getInvoiceItemByProductid(UUID id) {
        logger.info("Get InvoiceItem By Product_id inside getInvoiceItemByProductid successfully");
        return ResponseEntity.ok(invoiceItemsRepository.findByProductid(id));
    }

}
