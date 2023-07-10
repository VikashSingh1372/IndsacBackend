package com.unicorn.indsaccrm.common.referral.referralcourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Controller
@RequestMapping("/referralcourse")
public class ReferralCourseController {


    @Autowired ReferralCourseService referralCourseService;

    @PostMapping
    public ResponseEntity<?> generateReferralCourse() throws Exception {
        return ResponseEntity.ok(referralCourseService.saveReferralCourse());
    }

    @GetMapping("/all")
    public ResponseEntity<?>getAllReferralCourse()throws Exception{
        return ResponseEntity.ok(referralCourseService.getAllReferralCourse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getByReferralId(@PathVariable UUID id) throws Exception{
        return ResponseEntity.ok(referralCourseService.getByReferralById(id));
    }

    @GetMapping("/course/{courseid}")
    public ResponseEntity<?>getByReferralCourseId(@PathVariable UUID courseid) throws Exception{
        return ResponseEntity.ok(referralCourseService.getAllReferralCourseByCourseId(courseid));
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<?>getByReferralUserId(@PathVariable UUID userid) throws Exception{
        return ResponseEntity.ok(referralCourseService.getAllReferralCourseByUserId(userid));
    }

    @GetMapping("/invite/{userid}")
    public ResponseEntity<?>getByReferralInvitingUserId(@PathVariable UUID userid) throws Exception{
        return ResponseEntity.ok(referralCourseService.getAllReferralCourseByInvitingUser(userid));
    }
}
