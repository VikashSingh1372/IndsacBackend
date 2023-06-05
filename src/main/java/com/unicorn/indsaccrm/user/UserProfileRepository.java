package com.unicorn.indsaccrm.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserProfileRepository  extends CrudRepository<UserProfile, UUID>, JpaRepository<UserProfile, UUID> {

}
