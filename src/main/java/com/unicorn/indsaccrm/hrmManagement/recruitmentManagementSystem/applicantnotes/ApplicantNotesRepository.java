package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applicantnotes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface ApplicantNotesRepository extends JpaRepository<ApplicantNotes,UUID> {
    List<ApplicantNotes> findByApplicationid(UUID applicationid);
    List<ApplicantNotes> findByUsercid(UUID usercid);
    List<ApplicantNotes> findByUseradminid(UUID useradminid);
}
