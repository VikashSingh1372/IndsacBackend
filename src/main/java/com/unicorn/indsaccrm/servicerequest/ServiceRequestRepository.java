package com.unicorn.indsaccrm.servicerequest;

import com.unicorn.indsaccrm.servicerequest.ServiceRequest.ServiceRequestStatus;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, UUID> {
    List<ServiceRequest> findByUseradminid(UUID useradminid);
    List<ServiceRequest> findByUsercid(UUID usercid);
    List<ServiceRequest> findByCustomerid(UUID customerid);
    List<ServiceRequest> findByResolutionUserId(UUID ResolutionUserId);

    List<ServiceRequest> findByUseradminidAndCustomeridAndDuedateLessThanEqualAndStatusNotIn(
        UUID useradminid, UUID customerid, LocalDate duedate,
        List<ServiceRequestStatus> statuses);
    List<ServiceRequest> findByUseradminidAndCustomeridAndStatusNotIn(
        UUID useradminid, UUID customerid, List<ServiceRequestStatus> statuses);

    List<ServiceRequest> findByLeadid(UUID leadid);

    List<ServiceRequest> findByVendorid(UUID vendorid);

}
