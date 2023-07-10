package com.unicorn.indsaccrm.common.referral.UserReward;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class UserRewardImpl implements UserRewardService {

    @Autowired
    UserRewardRepository userRewardRepository;

    Logger logger = LoggerFactory.getLogger(UserRewardImpl.class);

    @Override
    public ResponseEntity<?> saveUserReward() {
        return ResponseEntity.ok(userRewardRepository.getClass());
    }
    @Override
    public ResponseEntity<List<UserReward>> getAllUserReward() {
        logger.info("Get All User_Reward Successfully");
        return ResponseEntity.ok(userRewardRepository.findAll());
    }
    @Override
    public ResponseEntity<Optional<UserReward>> getByUserRewardById(UUID Id) {
        logger.info("Get User_Reward Successfully");
        return ResponseEntity.ok(userRewardRepository.findById(Id));
    }

    @Override
    public ResponseEntity<List<UserReward>> getAllUserRewardByUserId(UUID userId) {
        logger.info("Get User_Reward Successfully");
        return ResponseEntity.ok(userRewardRepository.findByUserid(userId));
    }

}