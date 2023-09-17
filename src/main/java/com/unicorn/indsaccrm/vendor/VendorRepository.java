package com.unicorn.indsaccrm.vendor;

import com.unicorn.indsaccrm.Customer.Customer;
import com.unicorn.indsaccrm.lead.Lead;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface VendorRepository extends JpaRepository<Vendor, UUID> {

    long countById(UUID id);

    long countByIdAndStatusIn(UUID id, List<Vendor.VendorStatus> statusList);

    long countByStatusAndId(Vendor.VendorStatus status, UUID id);

    List<Vendor> findByUseradminidAndStatus(UUID useradminid, Vendor.VendorStatus status);

      long countByCreationDateAndUseradminid(
        Date creationDate, UUID useradminid);

    List<Vendor> findByUseradminid(UUID id);

    Optional<Vendor> findById(UUID id);


    @Query(value = "SELECT c.creationDate AS yearComment, COUNT(c.*) AS totalComment "
            + "FROM vendor AS c GROUP BY c.creationDate ORDER BY c.creationDate DESC", nativeQuery = true)
    List<Vendor> countTotalCustomerByYearNative();

    @Query(value = "SELECT MONTH(creation_date) AS month, COUNT(*) AS count "
            + "FROM vendor  "
            + "WHERE YEAR(creation_date) =  ?1 "
            + "AND MONTH(creation_date) = ?2 "
            // + "AND customerid = ?3 "
            + "GROUP BY MONTH(creation_date)", nativeQuery = true)
    List<?> countForYearAndMonth(String year,String month);


}
