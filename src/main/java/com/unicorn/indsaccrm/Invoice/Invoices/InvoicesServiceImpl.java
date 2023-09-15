package com.unicorn.indsaccrm.Invoice.Invoices;

import com.unicorn.indsaccrm.Invoice.Invoices.Invoice.InvoiceStatus;
import com.unicorn.indsaccrm.admindefaultvalues.AdminDefaultValuesService;
import java.time.LocalDate;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoicesServiceImpl implements InvoicesService {

    @Autowired
    InvoicesRepository invoicesRepository;

    @Autowired
    private AdminDefaultValuesService adminDefaultValuesService;

    Logger logger = LoggerFactory.getLogger(InvoicesServiceImpl.class);

    @Override
    public ResponseEntity<?> saveInvoices(Invoice invoice) {
        if(invoice.getDuedate()==null){
            LocalDate date=LocalDate.now().plusDays(Objects.requireNonNull(adminDefaultValuesService
                    .getByAdminDefaultValuesId(invoice.getUseradminid()).getBody())
                .getInvoiceduedayperiod());
            invoice.setDuedate(date);
        }
        logger.info("save Invoices inside saveInvoices successfully");
        return ResponseEntity.ok(invoicesRepository.save(invoice));
    }

    @Override
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        logger.info("Get all Invoices inside getAllInvoices successfully");
        return ResponseEntity.ok(invoicesRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Invoice>> getInvoicesByInvoiceId(UUID invoiceid) {
        logger.info("Get Invoices By InvoiceId inside getInvoicesByInvoiceId successfully");
        return ResponseEntity.ok(invoicesRepository.findById(invoiceid));
    }

    @Override
    public ResponseEntity<List<Invoice>> getInvoicesByCustomerId(UUID id) {
        logger.info("Get Invoices By Customer_id inside getInvoicesByCustomerId successfully");
        return ResponseEntity.ok(invoicesRepository.findByCustomerid(id));
    }

    @Override
    public ResponseEntity<List<Invoice>> getAllInvoicesByUserAdminId(UUID useradminid) {
        logger.info("Get Invoices By User_id inside getInvoicesByUserId successfully");
        return ResponseEntity.ok(invoicesRepository.findByUseradminid(useradminid));
    }

    @Override
    public ResponseEntity<List<Invoice>> getAllInvoicesByDueDateAndStatusNotIn(UUID customerid,
        UUID useradminid, LocalDate duedate, List<InvoiceStatus> statuses) {
        return ResponseEntity.ok(invoicesRepository.findByCustomeridAndUseradminidAndDuedateLessThanEqualAndStatusNotIn(
            customerid,useradminid,duedate,statuses
        ));
    }

    @Override
    public ResponseEntity<List<Invoice>> getAllInvoicesByStatusNotIn(UUID customerid,
        UUID useradminid,  List<InvoiceStatus> statuses) {
        return ResponseEntity.ok(invoicesRepository.findByCustomeridAndUseradminidAndStatusNotIn(
            customerid,useradminid,statuses
        ));
    }

}
