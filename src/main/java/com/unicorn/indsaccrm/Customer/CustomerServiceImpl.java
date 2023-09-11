package com.unicorn.indsaccrm.Customer;

import com.unicorn.indsaccrm.lead.Lead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private EntityManager entityManager;

    @Override
    public ResponseEntity<?> SaveCustomer(Customer customer) {
        logger.info("save Customer inside SaveCustomer successfully");
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @Override
    public ResponseEntity<List<Customer>> getAllCustomers() {
        logger.info("Get All Customers inside getAllCustomers successfully");
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @Override
    public ResponseEntity<List<Customer>> getCustomerByCustomerId(UUID customerid) {
        logger.info("GET Customer By Id inside getByIdCustomer successfully");
        return ResponseEntity.ok(customerRepository.findByCustomerid(customerid));

    }
        public ResponseEntity<CustomerResources.CustomerDashboard> getCustomerDashboard(UUID customerid){
            CustomerResources.CustomerDashboard customerDashboard = new CustomerResources.CustomerDashboard();
            customerDashboard.setTotalCustomer(customerRepository.countByCustomerid(customerid));
            customerDashboard.setConvertedCustomer(customerRepository.countByStatusAndCustomerid(Customer.CustomerStatus.CONVERTTOCUSTOMER, customerid));
            customerDashboard.setActiveCustomer(customerRepository.countByCustomeridAndStatusIn(customerid, Arrays.asList(Customer.CustomerStatus.NEEDSFOLLOWUP,
                    Customer.CustomerStatus.ATTEMPTEDCONTACT, Customer.CustomerStatus.NEWOPPORTUNITY, Customer.CustomerStatus.QUALIFIED, Customer.CustomerStatus.OPEN,
                    Customer.CustomerStatus.WORKING, Customer.CustomerStatus.NOTENGAGED)));
            customerDashboard.setInActiveCustomer(customerRepository.countByCustomeridAndStatusIn(customerid, Arrays.asList(Customer.CustomerStatus.DISQUALIFIED,
                    Customer.CustomerStatus.CONVERTTOCUSTOMER)));
             customerDashboard.setCustomerList(customerRepository.findByCustomerid(customerid));
             customerDashboard.setTotalCustomerAddedByMonthInCurrentYear(findCustomerCurrentYearCount(customerid));
             customerDashboard.setTotalCustomerInCurrentMonth(findTotalCustomerInCurrentMonth(customerid));
             customerDashboard.setCustomerCountByStatus(findTotalCustomerInStatus(customerid));
             logger.info("Get All CustomerDashboard");
             System.out.println("*********Debug*******");
             findCustomerInfo();
             return ResponseEntity.ok(customerDashboard);


        }
        private void findCustomerInfo(){
        System.out.println("--Customer Userid and count using createQuery(Tuple.class--");
            CriteriaBuilder cb=entityManager.getCriteriaBuilder();
            CriteriaQuery<Tuple> query =cb.createQuery(Tuple.class);
            Root<Customer> employee =query.from(Customer.class);
            query.select((cb.tuple(employee.get("Customerid"),
                         cb.count(employee.get("Customerid")))));

            TypedQuery<Tuple> typedQuery =entityManager.createQuery(query);
            List<Tuple> resultList =typedQuery.getResultList();
            resultList.forEach(tuple -> {
                 System.out.printf("Customerid: %s count: %S%n",
                         tuple.get(0, UUID.class), tuple.get(1, Long.class));
            });
            entityManager.close();
        }

        private Map<Integer, Long> findCustomerCurrentYearCount(UUID custoemrid) {
            Map<Integer, Long> currentYearInMonthsCountResult = new HashMap<>();
            logger.info("---Customer Current Count using createQuery(Tuple.class)--");
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class);
            Root<Customer> employee = query.from(Customer.class);
            query.select(cb.tuple(cb.function("MONTH", Integer.class, employee.get("creationDate")),
                    cb.count(employee.get("id"))));
            Predicate currentYearPredicate = cb.equal(cb.function("YEAR", Integer.class, employee.get("creationDate")), cb.function("YEAR", Integer.class, cb.currentTimestamp()));
            Predicate customeridPredicate = cb.equal(employee.get("customerid"),custoemrid);
            query.where(currentYearPredicate, customeridPredicate);
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
            private Map<Integer, Long> findTotalCustomerInCurrentMonth(UUID customerid) {
              Map<Integer,Long> currentMonthsDayCountResult = new HashMap<>();
              logger.info("--- Customer Current Months using CreateQurey (Tuple.class)--");
              CriteriaBuilder cb = entityManager.getCriteriaBuilder();
              CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class);
              Root<Customer> employee = query.from(Customer.class);
              query.select(cb.tuple(cb.function("DAY", Integer.class, employee.get("creationDate") ),
                      cb.count(employee.get("id"))));
              Predicate currentMonthPredicate =cb.equal(cb.function("MONTH", Integer.class, employee.get("creationDate") ),cb.function("MONTH", Integer.class, cb.currentTimestamp()));
              Predicate customeridPredicate = cb.equal(employee.get("Customerid"),customerid);
              query.where(currentMonthPredicate,customeridPredicate);
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

            private Map<Customer.CustomerStatus, Long> findTotalCustomerInStatus(UUID customerid){
                  Map<Customer.CustomerStatus,Long> currentMonthDayCountResult=new HashMap<>();
                  logger.info("--Customer status count using createQuery (Tuple.class)--");
                  CriteriaBuilder cb =entityManager.getCriteriaBuilder();
                  CriteriaQuery<Tuple> query =cb.createQuery(Tuple.class);
                  Root<Customer> employee =query.from(Customer.class);
                  query.select(cb.tuple(employee.get("status"),cb.count(employee.get("id"))));
                  Predicate customeridPredicate = cb.equal(employee.get("customerid"),customerid);
                  query.where(customeridPredicate);
                  query.groupBy(employee.get("Status"));
                  TypedQuery<Tuple> typedQuery= entityManager.createQuery(query);
                  List<Tuple> resultList =typedQuery.getResultList();
                  resultList.forEach(tuple -> {
                      currentMonthDayCountResult.put(tuple.get(0, Customer.CustomerStatus.class),tuple.get(1, Long.class));
                      System.out.printf("Status: %s, count: %s%n",
                              tuple.get(0,Customer.CustomerStatus.class), tuple.get(1, Long.class));
                  });
                  entityManager.close();
                  return currentMonthDayCountResult;
            }


}
