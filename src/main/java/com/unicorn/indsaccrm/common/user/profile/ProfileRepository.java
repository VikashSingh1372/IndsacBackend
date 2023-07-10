package com.unicorn.indsaccrm.common.user.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface ProfileRepository extends JpaRepository<Profile , UUID> {

    @Query("SELECT p FROM Profile p WHERE p.userid = :userid")
    List<Profile> findUserid(@Param("userid") UUID userid);
}
