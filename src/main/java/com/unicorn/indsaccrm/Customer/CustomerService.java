package com.unicorn.indsaccrm.Customer;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    ResponseEntity<?> SaveCustomer(Customer customer);

    ResponseEntity<List<Customer>> getAllCustomers();

    ResponseEntity<List<Customer>> getCustomerByCustomerId(UUID customerid);

    ResponseEntity<CustomerResources.CustomerDashboard> getCustomerDashboard(UUID customerid);
}
