package com.unicorn.indsaccrm.order;


import com.unicorn.indsaccrm.order.ProductOrder.OrderStatus;
import java.time.LocalDate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductOrderService {

    ResponseEntity<?> saveAllProductOrder(ProductOrder productOrder);

    ResponseEntity<List<ProductOrder>> getAllProductOder();

    ResponseEntity<Optional<ProductOrder>> getProductOrderById(UUID id);

    ResponseEntity<List<ProductOrder>> getProductOrderByCustomerId(UUID id);

    ResponseEntity<List<ProductOrder>> getProductOrderByUserAdminId(UUID id);

    ResponseEntity<List<ProductOrder>> getProductOrderByDueDateAndStatusNotIn(UUID customerid,UUID useradminid,
        LocalDate dueDate,List<OrderStatus> statusList);

    ResponseEntity<List<ProductOrder>> getProductOrderByStatusNotIn(UUID customerid,UUID useradminid,
        List<OrderStatus> statusList);
}
