package com.unicorn.indsaccrm.Invoice.InvoiceItems;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItems, UUID> {

    List<InvoiceItems> findByInvoice_id(UUID invoice_id);

    List<InvoiceItems> findByProduct_id(UUID product_id);


}
