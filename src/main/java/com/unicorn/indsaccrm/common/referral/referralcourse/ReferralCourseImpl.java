package com.unicorn.indsaccrm.common.referral.referralcourse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReferralCourseImpl implements ReferralCourseService{

    @Autowired
    ReferralCourseRepository referralCourseRepository;

    Logger logger= LoggerFactory.getLogger(ReferralCourseImpl.class);


    @Override
    public ResponseEntity<?> saveReferralCourse() {
        return ResponseEntity.ok(referralCourseRepository.getClass());
    }

    @Override
    public ResponseEntity<List<ReferralCourse>> getAllReferralCourse() {
        logger.info("Get All ReferralCourse Successfully");
        return ResponseEntity.ok(referralCourseRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<ReferralCourse>> getByReferralById(UUID Id) {
        logger.info("Get ReferralCourse Successfully");
        return ResponseEntity.ok(referralCourseRepository.findById(Id));
    }

    @Override
    public ResponseEntity<List<ReferralCourse>> getAllReferralCourseByInvitingUser(UUID invitingUserId) {
        logger.info("Get ReferralCourse Successfully");
        return ResponseEntity.ok(referralCourseRepository.findByInvitedUserID(invitingUserId));
    }

    @Override
    public ResponseEntity<List<ReferralCourse>> getAllReferralCourseByUserId(UUID userId) {
        logger.info("Get ReferralCourse Successfully");
        return ResponseEntity.ok(referralCourseRepository.findByUserid(userId));
    }

    @Override
    public ResponseEntity<List<ReferralCourse>> getAllReferralCourseByCourseId(UUID courseId) {
        logger.info("Get ReferralCourse Successfully");
        return ResponseEntity.ok(referralCourseRepository.findByCourseid(courseId));
    }

}
