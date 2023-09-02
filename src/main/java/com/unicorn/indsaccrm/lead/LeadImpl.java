package com.unicorn.indsaccrm.lead;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LeadImpl implements LeadService{
    @Autowired
    LeadRepository leadRepository;


    Logger logger= LoggerFactory.logger(LeadImpl.class);
    @Override
    public ResponseEntity<?> SaveAllLead(Lead lead) {
        return new ResponseEntity<>(leadRepository.save(lead), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Lead>> getAllLead() {
        logger.info("get all lead successfully");
        return ResponseEntity.ok(leadRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Lead>> getByIdLead(UUID id) {
        logger.info("get lead by id successfully");
        return ResponseEntity.ok(leadRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<Lead>> getAllLeadsByAdminId(UUID useradminid) {
        logger.info("get lead by usreadminid successfully");
        return ResponseEntity.ok(leadRepository.findByUseradminid(useradminid));
    }


    @Override
    public ResponseEntity<LeadResource.LeadDashboard> getLeadDahBoard(UUID useradminid) {
        LeadResource.LeadDashboard leadDashboard =new LeadResource.LeadDashboard();
       leadDashboard.setTotalLead(leadRepository.countByUseradminid(useradminid));
       leadDashboard.setConvertedLeads(leadRepository.countByStatusAndUseradminid(Lead.LeadStatus.CONVERTTOCUSTOMER,useradminid));
       leadDashboard.setActiveLead(leadRepository.countByUseradminidAndStatusIn(useradminid,Arrays.asList(Lead.LeadStatus.NEEDSFOLLOWUP,
              Lead.LeadStatus.ATTEMPTEDCONTACT,Lead.LeadStatus.NEWOPPORTUNITY,Lead.LeadStatus.QUALIFIED,Lead.LeadStatus.OPEN,
              Lead.LeadStatus.WORKING,Lead.LeadStatus.NOTENGAGED)));
     leadDashboard.setInActiveLead(leadRepository.countByUseradminidAndStatusIn(useradminid,Arrays.asList(Lead.LeadStatus.DISQUALIFIED,
             Lead.LeadStatus.CONVERTTOCUSTOMER)));
     leadDashboard.setLeadList(leadRepository.findByUseradminid(useradminid));
     System.out.println(leadRepository.getAllOfCurrentMonth(useradminid).stream().count());
     System.out.println(leadRepository.countForYearAndMonth("2023","9"));
        logger.info("Get all leaddashboard");
        return ResponseEntity.ok(leadDashboard);
    }


}
