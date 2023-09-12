package com.unicorn.indsaccrm.Customer;

import com.unicorn.indsaccrm.Invoice.Invoices.Invoice;
import com.unicorn.indsaccrm.Invoice.Invoices.InvoicesService;
import com.unicorn.indsaccrm.interactionrecord.InteractionRecord;
import com.unicorn.indsaccrm.interactionrecord.InteractionRecordService;
import com.unicorn.indsaccrm.order.ProductOrder;
import com.unicorn.indsaccrm.order.ProductOrderService;
import com.unicorn.indsaccrm.servicerequest.ServiceRequest;
import com.unicorn.indsaccrm.servicerequest.ServiceRequestService;
import com.unicorn.indsaccrm.task.Task;
import com.unicorn.indsaccrm.task.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    InvoicesService invoicesService;

    @Autowired
    ServiceRequestService serviceRequestService;

    @Autowired
    InteractionRecordService interactionRecordService;

    @Autowired
    TaskService taskService;

    @Autowired
    ProductOrderService productOrderService;

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
    public ResponseEntity<Optional<Customer>> getCustomerByCustomerId(UUID customerid) {
        logger.info("GET Customer By Id inside getByIdCustomer successfully");
        return ResponseEntity.ok(customerRepository.findById(customerid));
    }

    @Override
    public Customer getCustomerForCustomerDetailsResponse(UUID customerId) {
        logger.info("GET Customer By Id inside getByIdCustomer successfully");
        return customerRepository.findById(customerId).get();
    }

    //Set Values For CountInformation
    public CustomerResource.CountInformation CountInformation(){
        CustomerResource.CountInformation countInformation=new CustomerResource.CountInformation();
        countInformation.setTotalInvoice("");
        countInformation.setDuePayment("");
        countInformation.setTotalOrders("");
        return countInformation;
    }

    //Set Values for DueToday
    public CustomerResource.DueToday DueToday(){
        CustomerResource.DueToday dueToday=new CustomerResource.DueToday();
        dueToday.setType("R");
        dueToday.setSubject("Science");
        dueToday.setStatus("R");
        dueToday.setDuedate("11");
        dueToday.setPriority("7");
        dueToday.setAssigned("R");
        return dueToday;
    }

    //Set Values for OpenItems
    public CustomerResource.OpenItems OpenItems(){
        CustomerResource.OpenItems openItems=new CustomerResource.OpenItems();
        openItems.setType("C");
        openItems.setSubject("Maths");
        openItems.setStatus("R");
        openItems.setDuedate("11");
        openItems.setPriority("5");
        openItems.setAssigned("L");
        return openItems;
    }

    public CustomerResource.CustomerEventList CustomerEventList(UUID customerid){
        CustomerResource.CustomerEventList customerEventList=new CustomerResource.CustomerEventList();
        customerEventList.setOrderList((List<ProductOrder>) productOrderService.getProductOrderByCustomerId(customerid));
        customerEventList.setInvoiceList((List<Invoice>) invoicesService.getInvoicesByCustomerId(customerid));
        customerEventList.setPurchaseOrderList("00");
        customerEventList.setQuotationList("0");
        customerEventList.setServiceRequestList((List<ServiceRequest>) serviceRequestService.getServiceRequestByCustomerid(customerid));
        customerEventList.setTaskList((List<Task>) taskService.getTaskByCustomerId(customerid));
        customerEventList.setInteractionRecordList((List<InteractionRecord>) interactionRecordService.getInteractionRecordByCustomerId(customerid));
        return customerEventList;
    }

    public ResponseEntity<CustomerResource.CustomerDetailsResponse> getCustomerDetailsResponse(UUID customerid){
        CustomerResource.CustomerDetailsResponse customerDetailsResponse=new CustomerResource.CustomerDetailsResponse();
        customerDetailsResponse.setCustomer(getCustomerForCustomerDetailsResponse(customerid));
        customerDetailsResponse.setCount(CountInformation());
        customerDetailsResponse.setDueToday(DueToday());
        customerDetailsResponse.setEventList(CustomerEventList(customerid));
        return ResponseEntity.ok(customerDetailsResponse);
    }

}
