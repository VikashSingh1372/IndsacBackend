package com.unicorn.indsaccrm.expense;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExpenseService {

    ResponseEntity<?>saveAllExpense(Expense request);
    ResponseEntity<List<Expense>>getAllExpense();
    ResponseEntity<Optional<Expense>>getByID(UUID id);
}
