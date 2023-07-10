package com.unicorn.indsaccrm.common.oauth.group;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GroupService {
    ResponseEntity<?> saveGroup(Groups request);

    ResponseEntity<?> saveAllGroups(List<Groups> request);

    ResponseEntity<List<Groups>> getAllGroups();

    ResponseEntity<Optional<Groups>> getByGroupId(UUID id);

    ResponseEntity<Optional<Groups>> getByGroupName(String name);
}
