package com.unicorn.indsaccrm.common.referral.RewardTransaction;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RewardTransactionService {

    ResponseEntity<?> saveTransaction();

    ResponseEntity<List<RewardTransaction>> getAllTransaction();

    ResponseEntity<Optional<RewardTransaction>> getByTransactionById(UUID id);

}
