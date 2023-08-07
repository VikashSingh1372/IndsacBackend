package com.unicorn.indsaccrm.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Controller
@RequestMapping("/vendor")
public class VendorContoller {

    @Autowired
    VendorService vendorService;

    @PostMapping
    ResponseEntity<?> saveVendor(@RequestBody Vendor vendor)throws  Exception{
        return ResponseEntity.ok(vendorService.saveVendor(vendor));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllVendors()throws Exception{
        return ResponseEntity.ok(vendorService.getAllVendors());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getVendorByID(@PathVariable UUID id)throws Exception{
        return ResponseEntity.ok(vendorService.getVendorById(id));
    }
}
