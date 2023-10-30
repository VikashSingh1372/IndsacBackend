package com.unicorn.indsaccrm.hrmManagement.onBoarding.documents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface DocumentsRepository extends JpaRepository<Documents,UUID> {
    List<Documents> findByEmployeeid(UUID employeeid);
    List<Documents> findByUsercid(UUID usercid);
    List<Documents> findByUseradminid(UUID useradminid);
}
