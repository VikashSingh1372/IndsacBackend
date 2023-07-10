package com.unicorn.indsaccrm.common.user.usereducation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserEducationRepository extends CrudRepository<UserEducation, UUID>, JpaRepository<UserEducation, UUID> {
    List<UserEducation> findByUserid(UUID userid);
;}
