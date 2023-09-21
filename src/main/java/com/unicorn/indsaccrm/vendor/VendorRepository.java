package com.unicorn.indsaccrm.vendor;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface VendorRepository extends JpaRepository<Vendor, UUID> {

    long countById(UUID id);

    long countByIdAndStatusIn(UUID id, List<Vendor.VendorStatus> statusList);

    long countByStatusAndId(Vendor.VendorStatus status, UUID id);

    @Query("select l from Vendor l where l.useradminid = ?1 and l.status = ?2")
    List<Vendor> findByIdAndStatus(UUID id, Vendor.VendorStatus status);

    @Query("select count(l) from vendor l where l.useradminid = ?1 and l.creationDate = ?2")
    long countByDate(UUID id, Date creationDate);


    @Query("select l from vendor l where l.useradminid = ?1")
    List<Vendor> findByuseradminid(UUID id);

    @Query("select l from vendor l where l.useradminid = ?1")
    List<Vendor> findByid(UUID id);

    @Query("select e from Vendor e where year(e.creationDate) = year(current_date) and  month(e.creationDate) = month(current_date) and e.useradminid = ?1")
    List<Vendor> getAllOfCurrentMonth(UUID id);

    @Query(value = "SELECT c.creationDate AS yearComment, COUNT(c.*) AS totalComment "
            + "FROM Vendor AS c GROUP BY c.creationDate ORDER BY c.creationDate DESC", nativeQuery = true)
    List<Vendor> countTotalVendorByYearNative();

    @Query(value = "SELECT MONTH(creation_date) AS month, COUNT(*) AS count "
            + "FROM Customer  "
            + "WHERE YEAR(creation_date) =  ?1 "
            + "AND MONTH(creation_date) = ?2 "
            // + "AND useradminid = ?3 "
            + "GROUP BY MONTH(creation_date)", nativeQuery = true)
    List<?> countForYearAndMonth(String year,String month);


}
