package com.unicorn.indsaccrm.servicerequest;

import com.unicorn.indsaccrm.servicerequest.ServiceRequest.ServiceRequestStatus;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService{

    @Autowired
    ServiceRequestRepository serviceRequestRepository;

    Logger logger = LoggerFactory.getLogger(ServiceRequestServiceImpl.class);

    @Override
    public ResponseEntity<?> saveServiceRequest(ServiceRequest serviceRequest) {
        logger.info("Save ServiceRequest from saveServiceRequest Successully");
        return ResponseEntity.ok(serviceRequestRepository.save(serviceRequest));
    }

    @Override
    public ResponseEntity<List<ServiceRequest>> getAllServiceRequests() {
        logger.info("Get all ServiceRequests from getAllServiceRequests Successully");
        return ResponseEntity.ok(serviceRequestRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<ServiceRequest>> getServiceRequestById(UUID id) {
        logger.info("Get ServiceRequest from getServiceRequestById Successully");
        return ResponseEntity.ok(serviceRequestRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<ServiceRequest>> getServiceRequestByUseradminid(UUID id) {
        logger.info("Get ServiceRequest from getServiceRequestByUseradminid Successully");
        return ResponseEntity.ok(serviceRequestRepository.findByUseradminid(id));
    }

    @Override
    public ResponseEntity<List<ServiceRequest>> getServiceRequestByUsercid(UUID id) {
        logger.info("Get ServiceRequest from getServiceRequestByUsercid Successully");
        return ResponseEntity.ok(serviceRequestRepository.findByUsercid(id));
    }

    @Override
    public ResponseEntity<List<ServiceRequest>> getServiceRequestByCustomerid(UUID id) {
        logger.info("Get ServiceRequest from getServiceRequestByCustomerid Successully");
        return ResponseEntity.ok(serviceRequestRepository.findByCustomerid(id));
    }

    @Override
    public ResponseEntity<List<ServiceRequest>> getServiceRequestByResolutionUserId(UUID id) {
        logger.info("Get ServiceRequest from getServiceRequestByResolutionUserId Successully");
        return ResponseEntity.ok(serviceRequestRepository.findByResolutionUserId(id));
    }

    @Override
    public ResponseEntity<List<ServiceRequest>> getServiceRequestByDueDateAndStatusNotIn(
        UUID useradminid, UUID customerid, LocalDate duedate, List<ServiceRequestStatus> statuses) {
        return ResponseEntity.ok(serviceRequestRepository.findByUseradminidAndCustomeridAndDuedateLessThanEqualAndStatusNotIn(
            useradminid,customerid,duedate,statuses
            )
        );
    }

    @Override
    public ResponseEntity<List<ServiceRequest>> getServiceRequestByStatusNotIn(
        UUID useradminid, UUID customerid, List<ServiceRequestStatus> statuses) {
        return ResponseEntity.ok(serviceRequestRepository.findByUseradminidAndCustomeridAndStatusNotIn(
                useradminid,customerid,statuses
            )
        );
    }

}
