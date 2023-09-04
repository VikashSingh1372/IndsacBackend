package com.unicorn.indsaccrm.lead;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Service
public class LeadImpl implements LeadService{
    @Autowired
    LeadRepository leadRepository;

    @Autowired
    private EntityManager entityManager;

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

        leadDashboard.setTotalLeadAddedByMonthinCurrentYear(findLeadCurrentYearCount(useradminid));

        leadDashboard.setTotalLeadInCurrentMonth(findTotalLeadInCurrentMonth(useradminid));
        leadDashboard.setLeadCountByStatus(findTotalLeadInStatus(useradminid));
        logger.info("Get all leaddashboard");
        System.out.println("**************Debug************");
        findLeadInfo();
        return ResponseEntity.ok(leadDashboard);
    }


    private  void findLeadInfo() {
        System.out.println("-- Lead Userid and count using createQuery(Tuple.class) --");
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class);
        Root<Lead> employee = query.from(Lead.class);
        query.select(cb.tuple(employee.get("useradminid"),
                cb.count(employee.get("useradminid"))));
        TypedQuery<Tuple> typedQuery = entityManager.createQuery(query);
        List<Tuple> resultList = typedQuery.getResultList();
        resultList.forEach(tuple -> {
            System.out.printf("Useradminid: %s, count: %s%n",
                    tuple.get(0, UUID.class), tuple.get(1, Long.class));
        });
        entityManager.close();
    }
    private  Map<Integer,Long> findLeadCurrentYearCount(UUID useradminid) {
        Map<Integer,Long> currentYearInMonthsCountResult=new HashMap<>();
        logger.info("-- Lead Current Year count using createQuery(Tuple.class) --");
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class);
        Root<Lead> employee = query.from(Lead.class);
        query.select(cb.tuple(cb.function("MONTH", Integer.class, employee.get("creationDate") ),
                cb.count(employee.get("id"))));
        //Predicate currentMonthPredicate=cb.equal(cb.function("MONTH", Integer.class, employee.get("creationDate") ),cb.function("MONTH", Integer.class, cb.currentTimestamp()));
        Predicate currentYearPredicate=cb.equal(cb.function("YEAR", Integer.class, employee.get("creationDate") ),cb.function("YEAR", Integer.class, cb.currentTimestamp() ));
        Predicate useradminidPredicate=cb.equal( employee.get("useradminid"),useradminid);
        query.where(currentYearPredicate,useradminidPredicate);
        query.groupBy(cb.function("MONTH", Integer.class, employee.get("creationDate") ));
        TypedQuery<Tuple> typedQuery = entityManager.createQuery(query);
        List<Tuple> resultList = typedQuery.getResultList();
        resultList.forEach(tuple -> {
            currentYearInMonthsCountResult.put(tuple.get(0, Integer.class),tuple.get(1, Long.class));
            System.out.printf("Month: %s, count: %s%n",
                    tuple.get(0, Integer.class), tuple.get(1, Long.class));
        });
        entityManager.close();
        return currentYearInMonthsCountResult;
    }
    private  Map<Integer,Long> findTotalLeadInCurrentMonth(UUID useradminid) {
        Map<Integer,Long> currentMonthsDayCountResult=new HashMap<>();
        logger.info("-- Lead Current Month count using createQuery(Tuple.class) --");
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class);
        Root<Lead> employee = query.from(Lead.class);
        query.select(cb.tuple(cb.function("DAY", Integer.class, employee.get("creationDate") ),
                cb.count(employee.get("id"))));
        Predicate currentMonthPredicate=cb.equal(cb.function("MONTH", Integer.class, employee.get("creationDate") ),cb.function("MONTH", Integer.class, cb.currentTimestamp()));
        // Predicate currentYearPredicate=cb.equal(cb.function("YEAR", Integer.class, employee.get("creationDate") ),cb.function("YEAR", Integer.class, cb.currentTimestamp() ));
        Predicate useradminidPredicate=cb.equal( employee.get("useradminid"),useradminid);
        query.where(currentMonthPredicate,useradminidPredicate);
        query.groupBy(cb.function("DAY", Integer.class, employee.get("creationDate") ));
        TypedQuery<Tuple> typedQuery = entityManager.createQuery(query);
        List<Tuple> resultList = typedQuery.getResultList();
        resultList.forEach(tuple -> {
            currentMonthsDayCountResult.put(tuple.get(0, Integer.class),tuple.get(1, Long.class));
            System.out.printf("Day: %s, count: %s%n",
                    tuple.get(0, Integer.class), tuple.get(1, Long.class));
        });
        entityManager.close();
        return currentMonthsDayCountResult;
    }

    private  Map<Lead.LeadStatus,Long> findTotalLeadInStatus(UUID useradminid) {
        Map<Lead.LeadStatus,Long> currentMonthsDayCountResult=new HashMap<>();
        logger.info("-- Lead  Status count using createQuery(Tuple.class) --");
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class);
        Root<Lead> employee = query.from(Lead.class);
        query.select(cb.tuple( employee.get("status") ,
                cb.count(employee.get("id"))));
        Predicate useradminidPredicate=cb.equal( employee.get("useradminid"),useradminid);
        // Predicate currentYearPredicate=cb.equal(cb.function("YEAR", Integer.class, employee.get("creationDate") ),cb.function("YEAR", Integer.class, cb.currentTimestamp() ));
        query.where(useradminidPredicate);
        query.groupBy( employee.get("status"));
        TypedQuery<Tuple> typedQuery = entityManager.createQuery(query);
        List<Tuple> resultList = typedQuery.getResultList();
        resultList.forEach(tuple -> {
            currentMonthsDayCountResult.put(tuple.get(0, Lead.LeadStatus.class),tuple.get(1, Long.class));
            System.out.printf("Status: %s, count: %s%n",
                    tuple.get(0, Lead.LeadStatus.class), tuple.get(1, Long.class));
        });
        entityManager.close();
        return currentMonthsDayCountResult;
    }





}
