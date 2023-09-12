package com.unicorn.indsaccrm.Customer;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    ResponseEntity<?> SaveCustomer(Customer customer);

    ResponseEntity<List<Customer>> getAllCustomers();

    ResponseEntity<Optional<Customer>> getCustomerByCustomerId(UUID customerid);

    ResponseEntity<CustomerResource.CustomerDetailsResponse> getCustomerDetailsResponse(UUID customerid);

    //This Method used for CustomerDetailsResponse
    Customer getCustomerForCustomerDetailsResponse(UUID customerId);
}
