package com.unicorn.indsaccrm.organization;


import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationSerive {

    ResponseEntity<?> saveOrganization(Organization organization);

    ResponseEntity<List<Organization>> getAllOrganizations();

    ResponseEntity<Optional<Organization>> getOrganizationById(UUID id);

    ResponseEntity<List<Organization>> getOrganizationByUseradminid(UUID id);

    ResponseEntity<List<Organization>> getOrganizationByUsercid(UUID id);

    ResponseEntity<List<Organization>> getOrganizationByOwneruserid(UUID id);
}
