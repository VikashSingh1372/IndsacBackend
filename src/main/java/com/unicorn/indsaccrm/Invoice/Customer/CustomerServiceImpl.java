package com.unicorn.indsaccrm.Invoice.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public ResponseEntity<?> SaveCustomer(Customer customer) {
        logger.info("save Customer inside SaveCustomer successfully");
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @Override
    public ResponseEntity<List<Customer>> getAllCustomers() {
        logger.info("Get All Customers inside getAllCustomers successfully");
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Customer>> getCustomerByCustomerId(UUID customerid) {
        logger.info("GET Customer By Id inside getByIdCustomer successfully");
        return ResponseEntity.ok(customerRepository.findByCustomerid(customerid));
    }
}
