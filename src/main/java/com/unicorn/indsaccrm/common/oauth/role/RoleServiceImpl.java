package com.unicorn.indsaccrm.common.oauth.role;

import com.unicorn.indsaccrm.common.oauth.group.GroupRepository;
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
public class RoleServiceImpl implements RoleService{
    Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public ResponseEntity<?> saveRole(Role request) {
        logger.info("Role Saved Successfully");
        return  new ResponseEntity<>(roleRepository.save(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> saveAllRoles(List<Role> request) {
        logger.info("Role Saved Successfully");
        return  new ResponseEntity<>(roleRepository.saveAll(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Role>> getAllRoles() {
        logger.info("Get ALL Roles Successfully");
        return  ResponseEntity.ok(roleRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Role>> getByRoleId(UUID id) {
        logger.info("Get Role Successfully");
        return   ResponseEntity.ok(roleRepository.findById(id));
    }

    @Override
    public ResponseEntity<Optional<Role>> getByRoleName(String name) {
        logger.info("Get Role Successfully");
        return   ResponseEntity.ok(roleRepository.findByName(name));
    }
}
