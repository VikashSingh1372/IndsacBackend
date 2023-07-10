package com.unicorn.indsaccrm.common.referral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Controller
@RequestMapping("/referral")
public class ReferralController {

        @Autowired
        private ReferralService referralCodeService;

        @PostMapping
        public ResponseEntity<?> generateReferralCode() throws Exception {
        return ResponseEntity.ok(referralCodeService.generateReferralCode());
        }
        @GetMapping("/all")
        public ResponseEntity<?>getAllReferralCode()throws Exception{
            return ResponseEntity.ok(referralCodeService.getAllReferralCode());
        }
        @GetMapping("/{referralId}")
        public ResponseEntity<?>getByReferralCodeId(@PathVariable UUID referralId) throws Exception{
            return ResponseEntity.ok(referralCodeService.getByReferralCodeId(referralId));
        }

        @GetMapping("/user/{userid}")
        public ResponseEntity<?>getByReferralCodeIdByUserid(@PathVariable UUID userid) throws Exception{
                return ResponseEntity.ok(referralCodeService.getReferralCodeByUserid(userid));
        }

        @GetMapping("/validate/{referralCode}")
        public ResponseEntity<?>getByReferralCodeIdByUserid(@PathVariable String referralCode) throws Exception{
                return ResponseEntity.ok(referralCodeService.validateReferralCode(referralCode));
        }
        }


