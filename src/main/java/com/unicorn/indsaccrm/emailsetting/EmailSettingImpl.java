package com.unicorn.indsaccrm.emailsetting;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class EmailSettingImpl implements EmailSettingService {

    @Autowired
    EmailSettingRepo emailSettingRepo;

    Logger logger= LoggerFactory.logger(EmailSettingImpl.class);
    @Override
    public ResponseEntity<?> saveAllEmail(EmailSetting request) {
        emailSettingRepo.save(request);
        return new ResponseEntity<>("save all email successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EmailSetting>> getAllEmail() {
        logger.info("get all email successfully");
        return ResponseEntity.ok(emailSettingRepo.findAll());
    }

    @Override
    public ResponseEntity<Optional<EmailSetting>> getByIdEmail(UUID id) {
        logger.info("find email by id successfully");
        return ResponseEntity.ok(emailSettingRepo.findById(id));
    }
}
