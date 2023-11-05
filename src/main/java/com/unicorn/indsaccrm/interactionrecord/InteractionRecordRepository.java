package com.unicorn.indsaccrm.interactionrecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface InteractionRecordRepository extends JpaRepository<InteractionRecord, UUID> {
    List<InteractionRecord> findByCustomerid(UUID customerid);
    List<InteractionRecord> findByUseradminid(UUID useradminid);
    List<InteractionRecord> findByLeadid(UUID leadid);
    List<InteractionRecord> findByVendorid(UUID vendorid);
}
