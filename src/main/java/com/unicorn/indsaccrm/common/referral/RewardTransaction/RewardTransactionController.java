package com.unicorn.indsaccrm.common.referral.RewardTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@CrossOrigin
@Controller
@RequestMapping("/transaction")
public class RewardTransactionController {

    @Autowired
    RewardTransactionService rewardTransactionService;

    @PostMapping
    public ResponseEntity<?> generateTransaction() throws Exception {
        return ResponseEntity.ok(rewardTransactionService.saveTransaction());
    }

    @GetMapping ("/all")
    public ResponseEntity<?>getAllTransaction()throws Exception{
        return ResponseEntity.ok(rewardTransactionService.getAllTransaction());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getByTransactionId(@PathVariable UUID id) throws Exception{
        return ResponseEntity.ok(rewardTransactionService.getByTransactionById(id));
    }

}
