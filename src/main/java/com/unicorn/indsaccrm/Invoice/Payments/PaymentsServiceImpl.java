package com.unicorn.indsaccrm.Invoice.Payments;

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
    public ResponseEntity<Optional<Payments>> getPaymentsByPaymentId(UUID paymentid) {
        logger.info("Get Payments By Id inside getPaymentsByPaymentId successfully");
        return ResponseEntity.ok(paymentsRepository.findByPaymentid(paymentid));
    }

    @Override
    public ResponseEntity<List<Payments>> getAllPayments() {
        logger.info("Get all Payments getAllPayments successfully");
        return ResponseEntity.ok(paymentsRepository.findAll());
    }

    @Override
    public ResponseEntity<List<Payments>> getPaymentsByInvoiceId(UUID invoiceid) {
        logger.info("Get Payments By Invoice_id getPaymentsByInvoiceId successfully");
        return ResponseEntity.ok(paymentsRepository.findByInvoiceid(invoiceid));
    }
}
