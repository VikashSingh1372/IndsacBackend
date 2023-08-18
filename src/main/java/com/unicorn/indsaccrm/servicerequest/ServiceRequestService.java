package com.unicorn.indsaccrm.servicerequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiceRequestService {

    ResponseEntity<?> saveServiceRequest(ServiceRequest serviceRequest);

    ResponseEntity<List<ServiceRequest>> getAllServiceRequests();

    ResponseEntity<Optional<ServiceRequest>> getServiceRequestById(UUID id);

    ResponseEntity<List<ServiceRequest>> getServiceRequestByUseradminid(UUID id);

    ResponseEntity<List<ServiceRequest>> getServiceRequestByUsercid(UUID id);

    ResponseEntity<List<ServiceRequest>> getServiceRequestByCustomerid(UUID id);

    ResponseEntity<List<ServiceRequest>> getServiceRequestByResolutionUserId(UUID id);
}
