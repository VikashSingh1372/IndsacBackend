package com.unicorn.indsaccrm.order;


import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductOrderService {

    ResponseEntity<?> saveAllProductOrder(ProductOrder productOrder);

    ResponseEntity<List<ProductOrder>> getAllProductOder();

    ResponseEntity<Optional<ProductOrder>> getProductOrderById(UUID id);

    ResponseEntity<List<ProductOrder>> getProductOrderByCustomerId(UUID id);

    ResponseEntity<List<ProductOrder>> getProductOrderByUserAdminId(UUID id);
}
