package com.unicorn.indsaccrm.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

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
            customerDashboard.setConvertedCustomer(customerRepository.countByStatusAndCustomerid(Customer.CustomerStatus.CONVERTTOCUS, customerid));
            customerDashboard.setActiveCustomer(customerRepository.countByCustomeridAndStatusIn(customerid, Arrays.asList(Customer.CustomerStatus.NEEDSFOLLOWUP,
                    Customer.CustomerStatus.ATTEMPTEDCONTACT, Customer.CustomerStatus.NEWOPPORTUNITY, Customer.CustomerStatus.QUALIFIED, Customer.CustomerStatus.OPEN,
                    Customer.CustomerStatus.WORKING, Customer.CustomerStatus.NOTENGAGED)));
            customerDashboard.setInActiveCustomer(customerDashboard.setCustomerCountByStatus(customerid, Arrays.asList(Customer.CustomerStatus.DISQUALIFIED,
                    Customer.CustomerStatus.CONVERTTOCUSTOMER)));
            customerDashboard.setCustomerList(customerRepository.findByCustomerid(customerid));
            System.out.println(customerRepository.getAllOfCurrentMonth(customerid).stream().count());
            System.out.println(customerRepository.countForYearAndMonth("2023", "9"));
            logger.info("Get all CustomerDashboard");
            return ResponseEntity.ok(customerDashboard);
        }
    }

