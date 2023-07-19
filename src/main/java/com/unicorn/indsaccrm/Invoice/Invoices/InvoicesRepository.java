package com.unicorn.indsaccrm.Invoice.Invoices;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InvoicesRepository extends JpaRepository<Invoices, UUID> {
    List<Invoices> findByCustomer_id(UUID customer_id);

    List<Invoices> findByUser_id(UUID user_id);


}
