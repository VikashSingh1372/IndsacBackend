package com.unicorn.indsaccrm.common.oauth.group;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<Groups, UUID> {
    Optional<Groups> findByName(String name);
}
