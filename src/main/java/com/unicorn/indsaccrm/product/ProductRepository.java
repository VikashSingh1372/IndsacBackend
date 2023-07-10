package com.unicorn.indsaccrm.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product,UUID> {

    List<Product> findByUseradminid(UUID useradminid);

    List<Product> findByUsercid(UUID usercid);

    List<Product> findByCustomerid(UUID customerid);

    List<Product> findByInvoiceid(UUID invoiceid);

    List<Product> findByContactid(UUID contactid);

    List<Product> findByStockid(UUID stockid);

}
