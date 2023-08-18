package com.unicorn.indsaccrm.servicerequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/servicerequest")
public class ServiceRequestController {

    @Autowired
    ServiceRequestService serviceRequestService;

    @PostMapping
    ResponseEntity<?> createServiceRequest(@RequestBody ServiceRequest ServiceRequest)throws Exception{
        return ResponseEntity.ok(serviceRequestService.saveServiceRequest(ServiceRequest));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllServiceRequests()throws Exception{
        return ResponseEntity.ok(serviceRequestService.getAllServiceRequests());
    }

    @GetMapping("{id}")
    ResponseEntity<?> getServiceRequestByID(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(serviceRequestService.getServiceRequestById(id));
    }

    @GetMapping("/useradminid/{id}")
    ResponseEntity<?> getServiceRequestByUseradminid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(serviceRequestService.getServiceRequestByUseradminid(id));
    }

    @GetMapping("/usercid/{id}")
    ResponseEntity<?> getServiceRequestByUsercid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(serviceRequestService.getServiceRequestByUsercid(id));
    }

    @GetMapping("/customerid/{id}")
    ResponseEntity<?> getServiceRequestByCustomerid(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(serviceRequestService.getServiceRequestByCustomerid(id));
    }

    @GetMapping("/ResolutionUserId/{id}")
    ResponseEntity<?> getServiceRequestByResolutionUserId(@PathVariable UUID id)throws Exception {
        return ResponseEntity.ok(serviceRequestService.getServiceRequestByResolutionUserId(id));
    }


}
