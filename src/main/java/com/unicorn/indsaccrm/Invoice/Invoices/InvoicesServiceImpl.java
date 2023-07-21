package com.unicorn.indsaccrm.Invoice.Invoices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoicesServiceImpl implements InvoicesService {

    @Autowired
    InvoicesRepository invoicesRepository;

    Logger logger = LoggerFactory.getLogger(InvoicesServiceImpl.class);

    @Override
    public ResponseEntity<?> saveInvoices(Invoices invoices) {
        logger.info("save Invoices inside saveInvoices successfully");
        return ResponseEntity.ok(invoicesRepository.save(invoices));
    }

    @Override
    public ResponseEntity<List<Invoices>> getAllInvoices() {
        logger.info("Get all Invoices inside getAllInvoices successfully");
        return ResponseEntity.ok(invoicesRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Invoices>> getInvoicesByInvoiceId(UUID invoiceid) {
        logger.info("Get Invoices By InvoiceId inside getInvoicesByInvoiceId successfully");
        return ResponseEntity.ok(invoicesRepository.findByInvoiceid(invoiceid));
    }

    @Override
    public ResponseEntity<List<Invoices>> getInvoicesByCustomerId(UUID id) {
        logger.info("Get Invoices By Customer_id inside getInvoicesByCustomerId successfully");
        return ResponseEntity.ok(invoicesRepository.findByCustomerid(id));
    }

    @Override
    public ResponseEntity<List<Invoices>> getInvoicesByUserId(UUID id) {
        logger.info("Get Invoices By User_id inside getInvoicesByUserId successfully");
        return ResponseEntity.ok(invoicesRepository.findByUserid(id));
    }
}
