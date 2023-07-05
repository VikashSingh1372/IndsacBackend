package com.unicorn.indsaccrm.expence;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExpenseService {

    ResponseEntity<?>saveAllExpense(Expense request);
    ResponseEntity<List<Expense>>getAllExpense();
    ResponseEntity<Optional<Expense>>getByID(UUID id);
}
