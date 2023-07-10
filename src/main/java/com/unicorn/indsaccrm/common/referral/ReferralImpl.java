package com.unicorn.indsaccrm.common.referral;

import com.unicorn.indsaccrm.common.user.User;
import com.unicorn.indsaccrm.common.user.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReferralImpl implements ReferralService {
    private static final int REFERRAL_CODE_LENGTH = 8;

    @Autowired
    ReferralRepository referralCodeRepository;

    @Autowired
    UserService userService;


    Logger logger= LoggerFactory.getLogger(ReferralImpl.class);


    @Override
    public ResponseEntity<?> generateReferralCode() {
        Optional<User> user=userService.getCurrentUser();
        Referral existedReferral = referralCodeRepository.findByUserid(user.get().getId());
        if(existedReferral!=null){
           return ResponseEntity.ok(existedReferral.getReferralCode());
        }
        else {String referralcode = generateCode();
                Referral referral = new Referral();
                referral.setReferralCode(referralcode);
                referral.setUserid(user.get().getId());
                referralCodeRepository.save(referral);
                return ResponseEntity.ok(referralcode);
        }
    }
    @Override
    public ResponseEntity<List<Referral>> getAllReferralCode() {
        logger.info("Get All ReferralCode Successfully");
        return ResponseEntity.ok(referralCodeRepository.findAll());
    }
    @Override
    public ResponseEntity<Optional<Referral>> getByReferralCodeId(UUID Id) {
        logger.info("Get ReferralCode Successfully");
        return ResponseEntity.ok(referralCodeRepository.findById(Id));
    }

    @Override
    public ResponseEntity<?> validateReferralCode(String referralCode) {
        return ResponseEntity.ok(referralCodeRepository.existsByReferralCode(referralCode));
    }

    @Override
    public ResponseEntity<Referral> getReferralCodeByUserid(UUID userid) {
        return ResponseEntity.ok(referralCodeRepository.findByUserid(userid));
    }

    private String generateCode(){
        String referralcode = RandomStringUtils.randomAlphanumeric(REFERRAL_CODE_LENGTH).toLowerCase();
        if(!referralCodeRepository.existsByReferralCode(referralcode)){
            return referralcode;
        }else {
            generateCode();
            return null;
        }
    }


}
