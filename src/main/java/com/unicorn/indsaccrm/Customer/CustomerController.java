package com.unicorn.indsaccrm.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping
    ResponseEntity<?> createCustomer (@RequestBody Customer customer)throws  Exception{
        return ResponseEntity.ok(customerService.SaveCustomer(customer));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllCustomer()throws Exception{
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @GetMapping("/{customerid}")
    ResponseEntity<?> getCustomerByID(@PathVariable UUID customerid)throws Exception{
        return ResponseEntity.ok(customerService.getCustomerByCustomerId(customerid));
    }

    @GetMapping("/dashboard/{customerid}")
    ResponseEntity<?> getCustomerDashboard(@PathVariable UUID customerid)throws Exception{
        return ResponseEntity.ok(customerService.getCustomerDashboard(customerid));
    }

}
