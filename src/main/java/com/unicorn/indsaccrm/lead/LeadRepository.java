package com.unicorn.indsaccrm.lead;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public interface LeadRepository extends JpaRepository<Lead, UUID> {
    long countByUseradminid(UUID useradminid);

    long countByUseradminidAndStatusIn(UUID useradminid,List<Lead.LeadStatus> statusList);

    long countByStatusAndUseradminid(Lead.LeadStatus status, UUID useradminid);

    @Query("select l from Lead l where l.useradminid = ?1 and l.status = ?2")
    List<Lead> findByUseradminidAndStatus(UUID useradminid, Lead.LeadStatus status);

    @Query("select count(l) from Lead l where l.useradminid = ?1 and l.creationDate = ?2")
    long countByDate(UUID useradminid, Date creationDate);

    @Query("select l from Lead l where l.useradminid = ?1")
    List<Lead> findByUseradminid(UUID useradminid);



//    @Query(value = "SELECT MONTH(e.creationDate) AS month, COUNT(*) AS count "
//            + "FROM lead e "
//            + "WHERE YEAR(e.creationDate) =  ?1 "
//            + "AND MONTH(e.creationDate) = ?2 "
//            + "AND e.useradminid = ?3 "
//            + "GROUP BY MONTH(e.creationDate)")
//    List<Object[]> countForYearAndMonth(String year,String month,UUID useradminid);


//    @Query("select m from lead m where m.useradminid=137c2b51-5645-4218-9259-e7ef2705fe85 and SubString(cast(m.date as text),1,4) = :year")
//    List<Lead> buysForYear(@Param("year") String year);
}
