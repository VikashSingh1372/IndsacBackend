package com.unicorn.indsaccrm.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
}
