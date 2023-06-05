package com.unicorn.indsaccrm.oauth.googleouth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OautherRepository extends JpaRepository<OautharUserEntity, UUID> {
}
