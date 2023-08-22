package com.unicorn.indsaccrm.vendor;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VendorService {

    ResponseEntity<?> saveVendor(Vendor vendor);

    ResponseEntity<List<Vendor>> getAllVendors();

    ResponseEntity<Optional<Vendor>> getVendorById(UUID id);

    //Vendor Dashboard
    ResponseEntity<VendorResource.VendorDashboard>  getLeadDahBoard(UUID useradminid);
}
