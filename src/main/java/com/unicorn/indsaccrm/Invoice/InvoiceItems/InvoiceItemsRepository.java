package com.unicorn.indsaccrm.Invoice.InvoiceItems;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItems,UUID> {

    List<InvoiceItems> findByInvoiceid(UUID invoiceid);

    List<InvoiceItems> findByProductid(UUID productid);

}
