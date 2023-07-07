package com.unicorn.indsaccrm.lead;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface LeadRepository extends JpaRepository<Lead, UUID> {
}
