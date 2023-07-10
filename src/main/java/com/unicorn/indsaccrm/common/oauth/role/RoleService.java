package com.unicorn.indsaccrm.common.oauth.role;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleService {
    ResponseEntity<?> saveRole(Role request);

    ResponseEntity<?> saveAllRoles(List<Role> request);

    ResponseEntity<List<Role>> getAllRoles();

    ResponseEntity<Optional<Role>> getByRoleId(UUID id);

    ResponseEntity<Optional<Role>> getByRoleName(String name);
}
