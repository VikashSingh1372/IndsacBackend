package com.unicorn.indsaccrm.vendor;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    private VendorRepository vendorRepository;

    Logger logger= LoggerFactory.logger(VendorServiceImpl.class);
    @Override
    public ResponseEntity<?> saveVendor(Vendor vendor) {
        logger.info("save vendor from saveVendor successfully");
        return ResponseEntity.ok(vendorRepository.save(vendor));
    }

    @Override
    public ResponseEntity<List<Vendor>> getAllVendors() {
        logger.info("get all vendors from getAllVendors successfully");
        return ResponseEntity.ok(vendorRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Vendor>> getVendorById(UUID id) {
        logger.info("get vendor by id from getVendorById successfully");
        return ResponseEntity.ok(vendorRepository.findById(id));
    }
}
