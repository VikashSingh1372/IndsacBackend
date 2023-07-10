package com.unicorn.indsaccrm.common.user.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ProfileImpl implements ProfileService{
    @Autowired
    ProfileRepository profileRepository;
    Logger logger= LoggerFactory.getLogger(Profile.class);
    @Override
    public ResponseEntity<?> saveprofile(Profile requestuserprofile) {
        profileRepository.save(requestuserprofile);
        return new ResponseEntity<>("save successfully", HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<List<Profile>> getAllProfiles() {
        logger.info("getAlluserProfile successfully");
        return ResponseEntity.ok(profileRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Profile>> getByProfileId(UUID id) {
        logger.info("getting by id successfully");
        return ResponseEntity.ok(profileRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<Profile>> getByProfileUserId(UUID userId) {
        List<Profile>result=profileRepository.findUserid(userId);
        return ResponseEntity.ok(result);
    }
}
