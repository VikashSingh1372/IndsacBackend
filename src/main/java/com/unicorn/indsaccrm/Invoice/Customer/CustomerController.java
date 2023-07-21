package com.unicorn.indsaccrm.Invoice.Customer;

import com.unicorn.indsaccrm.lead.Lead;
import com.unicorn.indsaccrm.lead.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/Customer")
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
    ResponseEntity<?> getByIDCustomer(@PathVariable UUID customerid)throws Exception{
        return ResponseEntity.ok(customerService.getCustomerByCustomerId(customerid));
    }
}
