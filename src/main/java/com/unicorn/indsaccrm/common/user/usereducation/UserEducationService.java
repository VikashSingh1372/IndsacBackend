package com.unicorn.indsaccrm.common.user.usereducation;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserEducationService {
    ResponseEntity<?> saveUserEducation(UserEducation userEducation);
    ResponseEntity<List<UserEducation>>getAllUserEducationByUser(UUID userid);
    ResponseEntity<Optional<UserEducation>> getByUserEducationId(UUID id);
    ResponseEntity<List<UserEducation>>getAllUsers();


}
