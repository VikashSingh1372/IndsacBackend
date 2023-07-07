package com.unicorn.indsaccrm.emailsetting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface EmailSettingRepo extends JpaRepository<EmailSetting, UUID> {
}
