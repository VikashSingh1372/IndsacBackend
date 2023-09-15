package com.unicorn.indsaccrm.Invoice.Invoices;

import com.unicorn.indsaccrm.Invoice.Invoices.Invoice.InvoiceStatus;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InvoicesRepository extends JpaRepository<Invoice, UUID> {
        List<Invoice> findByCustomerid(UUID customerid);

  List<Invoice> findByUseradminid(UUID useradminid);

  List<Invoice> findByCustomeridAndUseradminidAndDuedateLessThanEqualAndStatusNotIn(
      UUID customerid, UUID useradminid, LocalDate duedate, List<InvoiceStatus> statuses);

  List<Invoice> findByCustomeridAndUseradminidAndStatusNotIn(
      UUID customerid, UUID useradminid, List<InvoiceStatus> statuses);

}
