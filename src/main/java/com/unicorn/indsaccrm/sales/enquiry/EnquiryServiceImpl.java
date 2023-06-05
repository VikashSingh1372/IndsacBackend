package com.unicorn.indsaccrm.sales.enquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiryServiceImpl implements EnquiryService{
    @Autowired
    EnquiryRepository enquiryRepository;

    @Override
    public ResponseEntity<?> saveEnquiry(Enquiry request) {
        enquiryRepository.save(request);
        return new ResponseEntity<>("Submitted successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Enquiry>> getAllEnquiry() {
        return new ResponseEntity<>(enquiryRepository.findAll(), HttpStatus.OK);
    }
}
