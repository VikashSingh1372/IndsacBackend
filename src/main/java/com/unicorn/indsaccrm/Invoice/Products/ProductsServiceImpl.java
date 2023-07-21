package com.unicorn.indsaccrm.Invoice.Products;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    ProductsRepository productsRepository;

    Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);

    @Override
    public ResponseEntity<?> saveProducts(Products products) {
        logger.info("save Products inside saveProducts successfully");
        return ResponseEntity.ok(productsRepository.save(products));
    }

    @Override
    public ResponseEntity<List<Products>> getAllProducts() {
        logger.info("Get all Products inside getAllProducts successfully");
        return ResponseEntity.ok(productsRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Products>> getProductsByProductId(UUID id) {
        logger.info("Get Products By Id inside getProductsByProductId successfully");
        return ResponseEntity.ok(productsRepository.findByProductid(id));
    }
}
