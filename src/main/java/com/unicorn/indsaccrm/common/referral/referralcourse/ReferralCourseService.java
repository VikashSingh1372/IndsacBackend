package com.unicorn.indsaccrm.common.referral.referralcourse;


import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReferralCourseService {

    ResponseEntity<?> saveReferralCourse();

    ResponseEntity<List<ReferralCourse>>getAllReferralCourse();

    ResponseEntity<Optional<ReferralCourse>> getByReferralById(UUID id);

    ResponseEntity<List<ReferralCourse>>getAllReferralCourseByInvitingUser(UUID invitingUserId);

    ResponseEntity<List<ReferralCourse>>getAllReferralCourseByUserId(UUID userId);

    ResponseEntity<List<ReferralCourse>>getAllReferralCourseByCourseId(UUID courseId);

}