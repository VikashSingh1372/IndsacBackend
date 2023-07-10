package com.unicorn.indsaccrm.common.referral.Reward;


import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RewardService {

    ResponseEntity<?> saveReward();

    ResponseEntity<List<Reward>>getAllReward();

    ResponseEntity<Optional<Reward>> getByRewardById(UUID id);
}
