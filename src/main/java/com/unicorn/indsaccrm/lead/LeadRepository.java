package com.unicorn.indsaccrm.lead;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface LeadRepository extends JpaRepository<Lead, UUID> {
    long countByUseradminid(UUID useradminid);

    @Query(value = "SELECT MONTH(e.arrivalDate) AS month, COUNT(*) AS count "
            + "FROM lead e "
            + "WHERE YEAR(e.arrivalDate) = 2023 "
            + "AND MONTH(e.arrivalDate) = 8 "
            + "GROUP BY MONTH(e.arrivalDate)")
    List<Object[]> countForYearAndMonth();

}
