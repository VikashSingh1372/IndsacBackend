package com.unicorn.indsaccrm.hrmManagement.employee.Departments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DepartmentsRepository extends JpaRepository<Departments, UUID> {
    List<Departments> findByUseradminid(UUID useradminid);
    List<Departments> findByUsercid(UUID usercid);
}
