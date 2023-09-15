package com.unicorn.indsaccrm.Customer;

import com.unicorn.indsaccrm.Customer.Customer.CustomerStatus;
import com.unicorn.indsaccrm.lead.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer,UUID> {

    long countById(UUID id);

    long countByIdAndStatusIn(UUID id, List<Customer.CustomerStatus> statusList);

    long countByStatusAndId(Customer.CustomerStatus status, UUID id);

    @Query("select c from Customer c where c.useradminid = ?1 and c.status = ?2")
    List<Customer> findByUseradminidAndStatus(UUID useradminid, CustomerStatus status);

    List<Customer> findByUseradminid(UUID useradminid);

    @Query("select e from Customer e where year(e.creationDate) = year(current_date) and  month(e.creationDate) = month(current_date) and e.useradminid = ?1")
    List<Lead> getAllOfCurrentMonth(UUID id);

    @Query(value = "SELECT c.creationDate AS yearComment, COUNT(c.*) AS totalComment "
            + "FROM Customer AS c GROUP BY c.creationDate ORDER BY c.creationDate DESC", nativeQuery = true)
    List<Customer> countTotalCustomerByYearNative();

    @Query(value = "SELECT MONTH(creation_date) AS month, COUNT(*) AS count "
            + "FROM Customer  "
            + "WHERE YEAR(creation_date) =  ?1 "
            + "AND MONTH(creation_date) = ?2 "
            // + "AND customerid = ?3 "
            + "GROUP BY MONTH(creation_date)", nativeQuery = true)
    List<?> countForYearAndMonth(String year,String month);



}
