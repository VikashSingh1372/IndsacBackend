package com.unicorn.indsaccrm.common.oauth.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleRepository  extends JpaRepository<Role, UUID>, CrudRepository<Role,UUID> {
    Optional<Role> findByName(String name);

    List<Role> findByNameIn(List<String> names);


}
