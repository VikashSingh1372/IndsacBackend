package com.unicorn.indsaccrm.Invoice.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer,UUID> {
    Optional<Customer> findByCustomerid(UUID customerid);

}
