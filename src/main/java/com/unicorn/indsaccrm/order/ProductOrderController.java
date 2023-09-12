package com.unicorn.indsaccrm.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/productorder")
public class ProductOrderController {
    @Autowired
    ProductOrderService productOrderService;

    @PostMapping
    ResponseEntity<?> createProductOrder(@RequestBody ProductOrder productOrder)throws Exception{
        return ResponseEntity.ok(productOrderService.saveAllProductOrder(productOrder));
    }
    @GetMapping("/all")
    ResponseEntity<?>getAllProductOrder()throws Exception{
        return ResponseEntity.ok(productOrderService.getAllProductOder());
    }
    @GetMapping("/{id}")
    ResponseEntity<?>getProductOrderById(@PathVariable UUID id)throws  Exception{
        return ResponseEntity.ok(productOrderService.getProductOrderById(id));
    }

    @GetMapping("/customerid/{id}")
    ResponseEntity<?> getProductOrderByCustomerId(@PathVariable UUID id)throws  Exception{
        return ResponseEntity.ok(productOrderService.getProductOrderByCustomerId(id));
    }
    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getTaskByUserAdminId(@PathVariable UUID id)throws  Exception{
        return ResponseEntity.ok(productOrderService.getProductOrderByUserAdminId(id));
    }
}
