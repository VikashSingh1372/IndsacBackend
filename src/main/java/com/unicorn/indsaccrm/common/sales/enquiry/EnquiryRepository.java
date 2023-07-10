package com.unicorn.indsaccrm.common.sales.enquiry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface EnquiryRepository extends JpaRepository<Enquiry, UUID> {
}
