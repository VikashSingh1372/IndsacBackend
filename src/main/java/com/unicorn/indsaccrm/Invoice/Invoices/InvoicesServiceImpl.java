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
    public ResponseEntity<Optional<Invoices>> getInvoicesById(UUID id) {
        logger.info("Get Invoices By Id inside getInvoicesById successfully");
        return ResponseEntity.ok(invoicesRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<Invoices>> getInvoicesByCustomer_id(UUID id) {
        logger.info("Get Invoices By Customer_id inside getInvoicesByCustomer_id successfully");
        return ResponseEntity.ok(invoicesRepository.findByCustomer_id(id));
    }

    @Override
    public ResponseEntity<List<Invoices>> getInvoicesByUser_id(UUID id) {
        logger.info("Get Invoices By User_id inside getInvoicesByUser_id successfully");
        return ResponseEntity.ok(invoicesRepository.findByUser_id(id));
    }
}
