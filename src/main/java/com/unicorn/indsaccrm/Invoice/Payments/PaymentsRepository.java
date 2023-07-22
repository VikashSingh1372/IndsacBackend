package com.unicorn.indsaccrm.Invoice.Payments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentsRepository extends JpaRepository<Payments,UUID> {
   Optional<Payments> findByPaymentid(UUID paymentid);
   List<Payments> findByInvoiceid(UUID invoiceid);
}
