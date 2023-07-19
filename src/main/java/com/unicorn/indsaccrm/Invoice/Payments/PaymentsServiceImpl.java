package com.unicorn.indsaccrm.Invoice.Payments;

import com.unicorn.indsaccrm.Invoice.Invoices.InvoicesServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentsServiceImpl implements PaymentsService{

    @Autowired
    PaymentsRepository paymentsRepository;

    Logger logger = LoggerFactory.getLogger(PaymentsServiceImpl.class);

    @Override
    public ResponseEntity<?> savePayments(Payments payments) {
        logger.info("save Payments inside savePayments successfully");
        return ResponseEntity.ok(paymentsRepository.save(payments));
    }

    @Override
    public ResponseEntity<Optional<Payments>> getPaymentsById(UUID id) {
        logger.info("Get Payments By Id inside getPaymentsById successfully");
        return ResponseEntity.ok(paymentsRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<Payments>> getAllPayments() {
        logger.info("Get all Payments getAllPayments successfully");
        return ResponseEntity.ok(paymentsRepository.findAll());
    }

    @Override
    public ResponseEntity<List<Payments>> getPaymentsByInvoice_id(UUID id) {
        logger.info("Get Payments By Invoice_id getPaymentsByInvoice_id successfully");
        return ResponseEntity.ok(paymentsRepository.findByInvoice_id(id));
    }
}
