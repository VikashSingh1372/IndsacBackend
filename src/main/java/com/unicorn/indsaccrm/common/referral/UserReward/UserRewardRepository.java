package com.unicorn.indsaccrm.common.referral.UserReward;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRewardRepository extends JpaRepository<UserReward, UUID> {

    List<UserReward> findByUserid(UUID userid);
}
