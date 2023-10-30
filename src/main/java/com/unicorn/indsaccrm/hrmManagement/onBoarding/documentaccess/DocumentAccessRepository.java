package com.unicorn.indsaccrm.hrmManagement.onBoarding.documentaccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface DocumentAccessRepository extends JpaRepository<DocumentAccess,UUID> {
    List<DocumentAccess> findByEmployeeid(UUID employeeid);
    List<DocumentAccess> findByDocumentid(UUID documentid);
    List<DocumentAccess> findByUsercid(UUID usercid);
    List<DocumentAccess> findByUseradminid(UUID useradminid);
}
