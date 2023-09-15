package com.unicorn.indsaccrm.order;

import com.unicorn.indsaccrm.order.ProductOrder.OrderStatus;
import java.time.LocalDate;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, UUID> {

    List<ProductOrder> findByCustomerId(UUID customerId);

    List<ProductOrder> findByUseradminid(UUID useradminid);

    List<ProductOrder> findByCustomerIdAndUseradminidAndDuedateLessThanEqualAndStatusNotIn(
        UUID customerId, UUID useradminid, LocalDate duedate, Collection<OrderStatus> statuses);

    List<ProductOrder> findByCustomerIdAndUseradminidAndStatusNotIn(
        UUID customerId, UUID useradminid, List<OrderStatus> statuses);

}
