package com.unicorn.indsaccrm.Invoice.Invoices;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvoicesRepository extends JpaRepository<Invoice, UUID> {
        List<Invoice> findByCustomerid(UUID customerid);
    List<Invoice> findByUserid(UUID userid);

}
