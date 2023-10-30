package com.unicorn.indsaccrm.hrmManagement.onBoarding.documentversions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface DocumentVersionsRepository extends JpaRepository<DocumentVersions,UUID> {
    List<DocumentVersions> findByEmployeeid(UUID employeeid);
    List<DocumentVersions> findByUsercid(UUID usercid);
    List<DocumentVersions> findByUseradminid(UUID useradminid);
}
