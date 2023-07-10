package com.unicorn.indsaccrm.common.referral.Reward;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Controller
@RequestMapping("/reward")
public class RewardController {

    @Autowired RewardService rewardService;

    @PostMapping
    public ResponseEntity<?> generateReward() throws Exception{
        return ResponseEntity.ok(rewardService.saveReward());
    }

    @GetMapping("/all")
    public ResponseEntity<?>getAllReward()throws Exception{
        return ResponseEntity.ok(rewardService.getAllReward());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getByRewardId(@PathVariable UUID id) throws Exception{
        return ResponseEntity.ok(rewardService.getByRewardById(id));
    }



}
