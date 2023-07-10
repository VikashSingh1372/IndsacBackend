package com.unicorn.indsaccrm.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Override
    public ResponseEntity<?> saveProduct(Product product) {
        logger.info("Save Product from saveProduct Successully");
        return ResponseEntity.ok(productRepository.save(product));
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        logger.info("GET all Products from getAllProducts Successully");
        return ResponseEntity.ok(productRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Product>> getProductById(UUID id) {
        logger.info("GET Product By Id from getProductById Successfully");
        return ResponseEntity.ok(productRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<Product>> getProductByUseradminid(UUID id) {
        logger.info("GET Product By Useradminid from getProductByUseradminid Successfully");
        return ResponseEntity.ok(productRepository.findByUseradminid(id));
    }

    @Override
    public ResponseEntity<List<Product>> getProductByUsercid(UUID id) {
        logger.info("GET Product By Usercid from getProductByUsercid Successfully");
        return ResponseEntity.ok(productRepository.findByUsercid(id));
    }

    @Override
    public ResponseEntity<List<Product>> getProductByCustomerid(UUID id) {
        logger.info("GET Product By Customerid from getProductByCustomerid Successfully");
        return ResponseEntity.ok(productRepository.findByCustomerid(id));
    }

    @Override
    public ResponseEntity<List<Product>> getProductByInvoiceid(UUID id) {
        logger.info("GET Product By Invoiceid from getProductByInvoiceid Successfully");
        return ResponseEntity.ok(productRepository.findByInvoiceid(id));
    }

    @Override
    public ResponseEntity<List<Product>> getProductByContactid(UUID id) {
        logger.info("GET Product By Contactid from getProductByContactid Successfully");
        return ResponseEntity.ok(productRepository.findByContactid(id));
    }

    @Override
    public ResponseEntity<List<Product>> getProductByStockid(UUID id) {
        logger.info("GET Product By Stockid from getProductByStockid Successfully");
        return ResponseEntity.ok(productRepository.findByStockid(id));
    }
}
