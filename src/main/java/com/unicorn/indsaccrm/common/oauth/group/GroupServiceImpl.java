package com.unicorn.indsaccrm.common.oauth.group;

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
public class GroupServiceImpl implements GroupService{

    Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
    @Autowired
    private GroupRepository groupRepository;
    @Override
    public ResponseEntity<?> saveGroup(Groups request) {
        logger.info("Group Saved Successfully");
        return  new ResponseEntity<>(groupRepository.save(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> saveAllGroups(List<Groups> request) {
        logger.info("Group Saved Successfully");
        return  new ResponseEntity<>(groupRepository.saveAll(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Groups>> getAllGroups() {
        logger.info("Get ALL Group Successfully");
        return  ResponseEntity.ok(groupRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Groups>> getByGroupId(UUID id) {
        logger.info("Get Role Successfully");
        return   ResponseEntity.ok(groupRepository.findById(id));
    }

    @Override
    public ResponseEntity<Optional<Groups>> getByGroupName(String name) {
        logger.info("Get Role Successfully");
        return   ResponseEntity.ok(groupRepository.findByName(name));
    }
}
