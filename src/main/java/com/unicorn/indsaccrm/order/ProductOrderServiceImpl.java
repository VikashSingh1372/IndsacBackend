package com.unicorn.indsaccrm.order;

import com.unicorn.indsaccrm.order.ProductOrder.OrderStatus;
import java.time.LocalDate;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService{

    @Autowired
    ProductOrderRepository productOrderRepository;

    Logger logger= LoggerFactory.logger(ProductOrderServiceImpl.class);
    @Override
    public ResponseEntity<?> saveAllProductOrder(ProductOrder productOrder) {
        logger.info("Save ProductOrder inside saveAllProductOrder successfully");
        return ResponseEntity.ok(productOrderRepository.save(productOrder));
    }

    @Override
    public ResponseEntity<List<ProductOrder>> getAllProductOder() {
        logger.info("Get All ProductOrders inside getAllProductOder successfully");
        return ResponseEntity.ok(productOrderRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<ProductOrder>> getProductOrderById(UUID id) {
        logger.info("Get ProductOrders By Id inside getProductOrderById successfully");
        return ResponseEntity.ok(productOrderRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<ProductOrder>> getProductOrderByCustomerId(UUID id) {
        logger.info("Get ProductOrder By CustomerId inside getProductOrderById successfully");
        return ResponseEntity.ok(productOrderRepository.findByCustomerId(id));
    }

    @Override
    public ResponseEntity<List<ProductOrder>> getProductOrderByUserAdminId(UUID id) {
        logger.info("Get ProductOrder By UserAdminId inside getProductOrderById successfully");
        return ResponseEntity.ok(productOrderRepository.findByUseradminid(id));
    }

    @Override
    public ResponseEntity<List<ProductOrder>> getProductOrderByDueDateAndStatusNotIn(
        UUID customerid,
        UUID useradminid, LocalDate dueDate, List<OrderStatus> statusList) {
        return ResponseEntity.ok(productOrderRepository.findByCustomerIdAndUseradminidAndDuedateLessThanEqualAndStatusNotIn(
            customerid,useradminid,dueDate,statusList
        ));
    }

    @Override
    public ResponseEntity<List<ProductOrder>> getProductOrderByStatusNotIn(
        UUID customerid, UUID useradminid,  List<OrderStatus> statusList) {
        return ResponseEntity.ok(productOrderRepository.findByCustomerIdAndUseradminidAndStatusNotIn(
            customerid,useradminid,statusList
        ));
    }

}
