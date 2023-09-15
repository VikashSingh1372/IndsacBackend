package com.unicorn.indsaccrm.vendor;


import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
public class VendorServiceImpl implements VendorService{

    @Autowired
    private VendorRepository vendorRepository;

    Logger logger= LoggerFactory.logger(VendorServiceImpl.class);
    private EntityManager entityManager;

    @Override
    public ResponseEntity<?> saveVendor(Vendor vendor) {
        logger.info("save vendor from saveVendor successfully");
        return ResponseEntity.ok(vendorRepository.save(vendor));
    }

    @Override
    public ResponseEntity<List<Vendor>> getAllVendors() {
        logger.info("get all vendors from getAllVendors successfully");
        return ResponseEntity.ok(vendorRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Vendor>> getVendorById(UUID id) {
        logger.info("get vendor by id from getVendorById successfully");
        return ResponseEntity.ok(vendorRepository.findById(id));
    }

    //Vendor Dashboard
    @Override
    public ResponseEntity<VendorResource.VendorDashboard>getVendorDashBoard(UUID useradminid) {
        VendorResource.VendorDashboard vendorDashboard = new VendorResource.VendorDashboard();
        vendorDashboard.setTotalVendor(vendorRepository.countById(useradminid));
        vendorDashboard.setTotalVendor(vendorRepository.countByStatusAndId(Vendor.VendorStatus.CONVERTTOCUSTOMER, useradminid));
        vendorDashboard.setActiveVendor(vendorRepository.countByIdAndStatusIn(useradminid, Arrays.asList(Vendor.VendorStatus.NEEDSFOLLOWUP,
                Vendor.VendorStatus.ATTEMPTEDCONTACT, Vendor.VendorStatus.NEWOPPORTUNITY, Vendor.VendorStatus.QUALIFIED, Vendor.VendorStatus.OPEN,
                Vendor.VendorStatus.WORKING, Vendor.VendorStatus.NOTENGAGED)));
        vendorDashboard.setInActiveVendor(vendorRepository.countByIdAndStatusIn(useradminid, Arrays.asList(Vendor.VendorStatus.DISQUALIFIED,Vendor.VendorStatus.CONVERTTOCUSTOMER)));
        vendorDashboard.setVendorList(vendorRepository.findByuseradminid(useradminid));
        vendorDashboard.setTotalVendorAddedByMonthinCurrentYear(findVendorCurrentYearCount(useradminid));
        vendorDashboard.setTotalVendorInCurrentMonth(findTotalVendorInCurrentMonth(useradminid));
        vendorDashboard.setVendorCountByStatus(findTotalVendorInStatus(useradminid));
        logger.info("Get All CustomerDashboard");
        System.out.println("*********Debug*******");
        findVendorInfo();
        return ResponseEntity.ok(vendorDashboard);


    }



    private void findVendorInfo(){
        System.out.println("--useradminid Userid and count using createQuery(Tuple.class--");
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query =cb.createQuery(Tuple.class);
        Root<Vendor> employee =query.from(Vendor.class);
        query.select((cb.tuple(employee.get("useradminid"),
                cb.count(employee.get("useradminid")))));

        TypedQuery<Tuple> typedQuery =entityManager.createQuery(query);
        List<Tuple> resultList =typedQuery.getResultList();
        resultList.forEach(tuple -> {
            System.out.printf("useradminid: %s count: %S%n",
                    tuple.get(0, UUID.class), tuple.get(1, Long.class));
        });
        entityManager.close();
    }

    private Map<Integer, Long> findVendorCurrentYearCount(UUID useradminid) {
        Map<Integer, Long> currentYearInMonthsCountResult = new HashMap<>();
        logger.info("---useradminid Current Count using createQuery(Tuple.class)--");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class);
        Root<Vendor> employee = query.from(Vendor.class);
        query.select(cb.tuple(cb.function("MONTH", Integer.class, employee.get("creationDate")),
                cb.count(employee.get("id"))));
        Predicate currentYearPredicate = cb.equal(cb.function("YEAR", Integer.class, employee.get("creationDate")), cb.function("YEAR", Integer.class, cb.currentTimestamp()));
        Predicate useradminidPredicate  = cb.equal(employee.get(" useradminid"), useradminid);
        query.where(currentYearPredicate, useradminidPredicate );
        query.groupBy(cb.function("MONTH", Integer.class, employee.get("creationDate")));
        TypedQuery<Tuple> typedQuery = entityManager.createQuery(query);
        List<Tuple> resultList = typedQuery.getResultList();
        resultList.forEach(tuple -> {
            currentYearInMonthsCountResult.put(tuple.get(0, Integer.class), tuple.get(1, Long.class));
            System.out.printf("Month: %s, count: %s%n",
                    tuple.get(0, Integer.class), tuple.get(1, Long.class));
        });
        entityManager.close();
        return currentYearInMonthsCountResult;
    }
    private Map<Integer, Long> findTotalVendorInCurrentMonth(UUID  useradminid) {
        Map<Integer,Long> currentMonthsDayCountResult = new HashMap<>();
        logger.info("--- useradminid Current Months using CreateQurey (Tuple.class)--");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class);
        Root<Vendor> employee = query.from(Vendor.class);
        query.select(cb.tuple(cb.function("DAY", Integer.class, employee.get("creationDate") ),
                cb.count(employee.get("id"))));
        Predicate currentMonthPredicate =cb.equal(cb.function("MONTH", Integer.class, employee.get("creationDate") ),cb.function("MONTH", Integer.class, cb.currentTimestamp()));
        Predicate useradminidPredicate  = cb.equal(employee.get("useradminid"),useradminid);
        query.where(currentMonthPredicate,useradminidPredicate );
        query.groupBy(cb.function("DAY", Integer.class, employee.get("creationDate") ));
        TypedQuery<Tuple> typedQuery =entityManager.createQuery(query);
        List<Tuple> resultList= typedQuery.getResultList();
        resultList.forEach(tuple -> {
            currentMonthsDayCountResult.put(tuple.get(0, Integer.class),tuple.get(1, Long.class));
            System.out.printf("Day: %s, count: %s%n",
                    tuple.get(0, Integer.class), tuple.get(1, Long.class));
        });
        entityManager.close();
        return currentMonthsDayCountResult;
    }

    private Map<Vendor.VendorStatus, Long> findTotalVendorInStatus(UUID useradminid){
        Map<Vendor.VendorStatus,Long> currentMonthDayCountResult=new HashMap<>();
        logger.info("-- useradminid status count using createQuery (Tuple.class)--");
        CriteriaBuilder cb =entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query =cb.createQuery(Tuple.class);
        Root<Vendor> employee =query.from(Vendor.class);
        query.select(cb.tuple(employee.get("status"),cb.count(employee.get("id"))));
        Predicate useradminidPredicate  = cb.equal(employee.get("useradminid"),useradminid);
        query.where(useradminidPredicate );
        query.groupBy(employee.get("Status"));
        TypedQuery<Tuple> typedQuery= entityManager.createQuery(query);
        List<Tuple> resultList =typedQuery.getResultList();
        resultList.forEach(tuple -> {
            currentMonthDayCountResult.put(tuple.get(0, Vendor.VendorStatus.class),tuple.get(1, Long.class));
            System.out.printf("Status: %s, count: %s%n",
                    tuple.get(0,Vendor.VendorStatus.class), tuple.get(1, Long.class));
        });
        entityManager.close();
        return currentMonthDayCountResult;
    }

}

