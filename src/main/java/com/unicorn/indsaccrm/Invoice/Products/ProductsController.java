package com.unicorn.indsaccrm.Invoice.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @PostMapping
    ResponseEntity<?> saveProducts(@RequestBody Products products) throws Exception{
        return ResponseEntity.ok(productsService.saveProducts(products));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllProducts() throws Exception{
        return ResponseEntity.ok(productsService.getAllProducts());
    }

    @GetMapping("/{productid}")
    ResponseEntity<?> getProductsByProductId(@PathVariable UUID productid) throws Exception{
        return ResponseEntity.ok(productsService.getProductsByProductId(productid));
    }
}
