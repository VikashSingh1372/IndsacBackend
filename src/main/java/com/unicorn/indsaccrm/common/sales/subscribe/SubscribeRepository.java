package com.unicorn.indsaccrm.common.sales.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubscribeRepository extends JpaRepository<Subscribe, UUID> {
}
