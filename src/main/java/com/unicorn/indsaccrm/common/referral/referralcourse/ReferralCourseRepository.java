package com.unicorn.indsaccrm.common.referral.referralcourse;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReferralCourseRepository extends JpaRepository<ReferralCourse, UUID> {
    List<ReferralCourse> findByCourseid(UUID courseid);

    List<ReferralCourse> findByUserid(UUID userid);

    List<ReferralCourse> findByInvitedUserID(UUID invitedUserID);

}
