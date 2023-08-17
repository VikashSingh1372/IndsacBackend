package com.unicorn.indsaccrm.servicerequest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, UUID> {
    List<ServiceRequest> findByUseradminid(UUID useradminid);
    List<ServiceRequest> findByUsercid(UUID usercid);
    List<ServiceRequest> findByCustomerid(UUID customerid);
    List<ServiceRequest> findByResolutionUserId(UUID ResolutionUserId);







}
