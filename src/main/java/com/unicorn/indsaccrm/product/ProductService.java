package com.unicorn.indsaccrm.product;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    ResponseEntity<?> saveProduct(Product product);

    ResponseEntity<List<Product>> getAllProducts();

    ResponseEntity<Optional<Product>> getProductById(UUID id);

    ResponseEntity<List<Product>> getProductByUseradminid(UUID id);

    ResponseEntity<List<Product>> getProductByUsercid(UUID id);

    ResponseEntity<List<Product>> getProductByCustomerid(UUID id);

    ResponseEntity<List<Product>> getProductByInvoiceid(UUID id);

    ResponseEntity<List<Product>> getProductByContactid(UUID id);

    ResponseEntity<List<Product>> getProductByStockid(UUID id);
}
