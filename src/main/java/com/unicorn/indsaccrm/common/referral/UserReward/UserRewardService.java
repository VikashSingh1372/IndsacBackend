package com.unicorn.indsaccrm.common.referral.UserReward;


import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRewardService {

    ResponseEntity<?>saveUserReward();

    ResponseEntity<List<UserReward>>getAllUserReward();

    ResponseEntity<Optional<UserReward>>getByUserRewardById(UUID id);

    ResponseEntity<List<UserReward>>getAllUserRewardByUserId(UUID userId);
}
