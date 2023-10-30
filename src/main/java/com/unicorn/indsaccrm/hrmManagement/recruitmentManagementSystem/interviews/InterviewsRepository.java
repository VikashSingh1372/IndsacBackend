package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.interviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface InterviewsRepository extends JpaRepository<Interviews,UUID> {
    List<Interviews> findByApplicationid(UUID applicationid);
    List<Interviews> findByUsercid(UUID usercid);
    List<Interviews> findByUseradminid(UUID useradminid);
}
