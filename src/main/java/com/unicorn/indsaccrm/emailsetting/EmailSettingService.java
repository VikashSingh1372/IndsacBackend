package com.unicorn.indsaccrm.emailsetting;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmailSettingService {
    ResponseEntity<?> saveAllEmail(EmailSetting request);
    ResponseEntity<List<EmailSetting>> getAllEmail();
    ResponseEntity<Optional<EmailSetting>> getByIdEmail(UUID id);
}
