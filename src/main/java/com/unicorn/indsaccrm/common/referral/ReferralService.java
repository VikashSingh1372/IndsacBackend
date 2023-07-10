package com.unicorn.indsaccrm.common.referral;


import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReferralService {

    ResponseEntity<?> generateReferralCode();

    ResponseEntity<List<Referral>>getAllReferralCode();

     ResponseEntity<Optional<Referral>> getByReferralCodeId(UUID id);

    ResponseEntity<?> validateReferralCode(String referralCode);

    ResponseEntity<Referral> getReferralCodeByUserid(UUID userid);
}
