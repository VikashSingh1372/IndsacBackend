package com.unicorn.indsaccrm.Invoice.Products;

import com.unicorn.indsaccrm.Invoice.Invoices.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductsRepository extends JpaRepository<Products,UUID>{


}
