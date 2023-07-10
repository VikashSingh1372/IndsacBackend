package com.unicorn.indsaccrm.interactionrecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface InteractionRecordRepository extends JpaRepository<InteractionRecord, UUID> {
}
