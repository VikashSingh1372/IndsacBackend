package com.unicorn.indsaccrm.Invoice.Payments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentsRepository extends JpaRepository<Payments,UUID> {
    List<Payments> findByInvoice_id(UUID invoice_id);

}
