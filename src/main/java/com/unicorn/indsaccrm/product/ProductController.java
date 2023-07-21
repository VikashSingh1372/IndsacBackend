package com.unicorn.indsaccrm.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    ResponseEntity<?> createProduct(@RequestBody Product product)throws Exception{
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllProducts()throws Exception{
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("{id}")
    ResponseEntity<?> getProductByID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getProductByUseradminid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(productService.getProductByUseradminid(id));
    }

    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getProductByUsercid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(productService.getProductByUsercid(id));
    }

    @GetMapping("/customerid/{id}")
    ResponseEntity<?> getProductByCustomerid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(productService.getProductByCustomerid(id));
    }

    @GetMapping("/invoiceid/{id}")
    ResponseEntity<?> getProductByInvoiceid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(productService.getProductByInvoiceid(id));
    }

    @GetMapping("/contactid/{id}")
    ResponseEntity<?> getProductByContactid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(productService.getProductByContactid(id));
    }

    @GetMapping("/stockid/{id}")
    ResponseEntity<?> getProductByStockid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(productService.getProductByStockid(id));
    }
}
