package com.unicorn.indsaccrm.common.referral.Reward;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class RewardServiceImpl implements RewardService{

    @Autowired
    RewardRepository rewardRepository;

    Logger logger= LoggerFactory.getLogger(RewardServiceImpl.class);

    @Override
    public ResponseEntity<?> saveReward() {
        return ResponseEntity.ok(rewardRepository.getClass());
    }

    @Override
    public ResponseEntity<List<Reward>> getAllReward() {
        logger.info("Get All Rewards Successfully");
        return ResponseEntity.ok(rewardRepository.findAll());
    }
    @Override
    public ResponseEntity<Optional<Reward>> getByRewardById(UUID Id) {
        logger.info("Get Rewards Successfully");
        return ResponseEntity.ok(rewardRepository.findById(Id));
    }
}
