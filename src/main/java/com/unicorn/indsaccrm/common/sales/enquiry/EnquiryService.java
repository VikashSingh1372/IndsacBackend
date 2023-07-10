package com.unicorn.indsaccrm.common.sales.enquiry;

import org.springframework.http.ResponseEntity;

import java.util.List;


public interface EnquiryService {
    ResponseEntity<?> saveEnquiry(Enquiry request);

    ResponseEntity<List<Enquiry>> getAllEnquiry();
}
