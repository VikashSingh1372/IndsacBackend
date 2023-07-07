package com.unicorn.indsaccrm.expence;


import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ExpenseImpl implements ExpenseService{
    @Autowired
    ExpenseRepository expenseRepository;
    Logger logger= LoggerFactory.logger(ExpenseImpl.class);
    @Override
    public ResponseEntity<?> saveAllExpense(Expense request) {
        expenseRepository.save(request);
        return new ResponseEntity<>("save expence successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Expense>> getAllExpense() {
        logger.info("get all expence successfully");
        return ResponseEntity.ok(expenseRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Expense>> getByID(UUID id) {
        logger.info("expence get by id successfully");
        return ResponseEntity.ok(expenseRepository.findById(id));
    }
}
