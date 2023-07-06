package com.unicorn.indsaccrm.admindefaultvalues;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AdminDefaultValuesRepository extends JpaRepository<AdminDefaultValues,UUID> {
    List<AdminDefaultValues> findByUsercid(UUID usercid);

    List<AdminDefaultValues> findByUseradminid(UUID useradminid);

}
