package com.unicorn.indsaccrm.organization;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {

    List<Organization> findByUseradminid(UUID useradminid);

    List<Organization> findByUsercid(UUID usercid);

    List<Organization> findByOwneruserid(UUID owneruserid);



}
