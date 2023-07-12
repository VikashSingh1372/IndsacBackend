package com.unicorn.indsaccrm.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company,UUID> {

    List<Company> findByUseradminid(UUID useradminid);

    List<Company> findByUsercid(UUID usercid);

    List<Company> findByOwneruserid(UUID owneruserid);



}
