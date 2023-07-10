package com.unicorn.indsaccrm.common.referral.UserReward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Controller
@RequestMapping("/user_reward")
public class UserRewardController {

    @Autowired UserRewardService userRewardService;

    @PostMapping
    public ResponseEntity<?> generateUserReward() throws Exception {
        return ResponseEntity.ok(userRewardService.saveUserReward());
    }

    @GetMapping("/all")
    public ResponseEntity<?>getAllUserReward()throws Exception {
        return ResponseEntity.ok(userRewardService.getAllUserReward());
    }


    @GetMapping("/user/{userid}")
    public ResponseEntity<?>getByRewardUserId(@PathVariable UUID userid) throws Exception{
        return ResponseEntity.ok(userRewardService.getAllUserRewardByUserId(userid));
    }

    @GetMapping("/{reward_id}")
    public ResponseEntity<?>getByUserRewardById(@PathVariable UUID Id) throws Exception{
        return ResponseEntity.ok(userRewardService.getByUserRewardById(Id));
    }
}
