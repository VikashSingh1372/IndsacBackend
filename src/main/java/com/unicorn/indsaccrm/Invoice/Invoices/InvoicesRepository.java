package com.unicorn.indsaccrm.Invoice.Invoices;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvoicesRepository extends JpaRepository<Invoices, UUID> {
    Optional<Invoices> findByInvoiceid(UUID invoiceid);
    List<Invoices> findByCustomerid(UUID customerid);
    List<Invoices> findByUserid(UUID userid);

}
