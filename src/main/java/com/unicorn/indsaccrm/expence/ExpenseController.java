package com.unicorn.indsaccrm.expence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("expense")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;
    @PostMapping
    ResponseEntity<?>createAuthenticationToken(@RequestBody Expense expense)throws Exception{
        return ResponseEntity.ok(expenseService.saveAllExpense(expense));
    }
    @GetMapping("/all")
    ResponseEntity<?>getAllexpense()throws Exception{
        return ResponseEntity.ok(expenseService.getAllExpense());
    }
    @GetMapping("/{id}")
    ResponseEntity<?>getbyID(@PathVariable UUID id)throws Exception{
        return ResponseEntity.ok(expenseService.getByID(id));
    }
}
