package com.unicorn.indsaccrm.Invoice.Customer;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    ResponseEntity<?> SaveCustomer(Customer customer);

    ResponseEntity<List<Customer>> getAllCustomers();

    ResponseEntity<Optional<Customer>> getCustomerByCustomerId(UUID customerid);
}
