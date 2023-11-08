package com.unicorn.indsaccrm.Customer;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    ResponseEntity<?> SaveCustomer(Customer customer);

    ResponseEntity<List<Customer>> getAllCustomers();

  ResponseEntity<List<Customer>> getAllCustomerByUserAdminId(UUID useradminid);


  ResponseEntity<Optional<Customer>> getCustomerById(UUID customerid);

    ResponseEntity<CustomerResources.CustomerDashboard> getCustomerDashboard(UUID useradminid);
  ResponseEntity<CustomerResource.CustomerDetailsResponse> getCustomerDetailsResponse(UUID customerid);

}
