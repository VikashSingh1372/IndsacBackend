package com.unicorn.indsaccrm.common.referral.RewardTransaction;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class RewardTransactionImpI implements RewardTransactionService{

    @Autowired
    RewardTransactionRepository rewardTransactionRepository;

    Logger logger = LoggerFactory.getLogger(RewardTransactionImpI.class);

    @Override
    public ResponseEntity<?> saveTransaction() {
        return ResponseEntity.ok(rewardTransactionRepository.getClass());
    }
    @Override
    public ResponseEntity<List<RewardTransaction>> getAllTransaction() {
        logger.info("Get All Transaction Successfully");
        return ResponseEntity.ok(rewardTransactionRepository.findAll());
    }
    @Override
    public ResponseEntity<Optional<RewardTransaction>> getByTransactionById(UUID Id) {
        logger.info("Get Reward_Transaction Successfully");
        return ResponseEntity.ok(rewardTransactionRepository.findById(Id));
    }

}


