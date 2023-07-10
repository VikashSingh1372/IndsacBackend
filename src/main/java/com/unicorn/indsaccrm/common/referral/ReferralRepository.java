package com.unicorn.indsaccrm.common.referral;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReferralRepository extends JpaRepository<Referral, UUID> {

    boolean existsByReferralCode(String referralCode);

    boolean existsByReferralCodeAndUserid(String referralCode,UUID userid);

    Referral findByUserid(UUID userid);

    Referral findByReferralCode(String referralCode);
}
