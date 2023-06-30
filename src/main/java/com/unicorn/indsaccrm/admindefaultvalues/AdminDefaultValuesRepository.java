package com.unicorn.indsaccrm.admindefaultvalues;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminDefaultValuesRepository extends JpaRepository<AdminDefaultValues,UUID> {
}
