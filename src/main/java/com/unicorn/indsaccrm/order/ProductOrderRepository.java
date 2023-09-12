package com.unicorn.indsaccrm.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, UUID> {

    List<ProductOrder> findByCustomerId(UUID customerId);

    List<ProductOrder> findByUseradminid(UUID useradminid);

}
