package com.unicorn.indsaccrm.Invoice.Products;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductsService {

    ResponseEntity<?> saveProducts(Products products);

    ResponseEntity<List<Products>> getAllProducts();

    ResponseEntity<Optional<Products>> getProductsByProductId(UUID productid);
}
