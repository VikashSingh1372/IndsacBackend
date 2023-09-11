package com.unicorn.indsaccrm.lead;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public interface LeadService {

    ResponseEntity<?>SaveAllLead(Lead lead);

    ResponseEntity<List<Lead>>getAllLead();

    ResponseEntity<Optional<Lead>>getByIdLead(UUID id);

    ResponseEntity<List<Lead>> getAllLeadsByAdminId(UUID useradminid);

    ResponseEntity<LeadResource.LeadDashboard> getLeadDahBoard(UUID useradminid);
}
