package com.unicorn.indsaccrm.Customer;

import com.unicorn.indsaccrm.Customer.CustomerResource.CountInformation;
import com.unicorn.indsaccrm.Customer.CustomerResource.CustomerDetailsResponse;
import com.unicorn.indsaccrm.Invoice.Invoices.Invoice;
import com.unicorn.indsaccrm.Invoice.Invoices.InvoicesService;
import com.unicorn.indsaccrm.common.exception.ResourceNotFoundException;
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

    public void setCustomerEventList(UUID customerid,CustomerDetailsResponse customerDetailsResponse){
        CustomerResource.CustomerEventList customerEventList=new CustomerResource.CustomerEventList();

        List<Invoice> invoiceList= (List<Invoice>) invoicesService.getInvoicesByCustomerId(customerid).getBody();
        List<ProductOrder> orderList=(List<ProductOrder>) productOrderService.getProductOrderByCustomerId(customerid).getBody();

        List<ServiceRequest> serviceRequestList=(List<ServiceRequest>) serviceRequestService
            .getServiceRequestByCustomerid(customerid).getBody();
        List<Task> taskList=(List<Task>) taskService.getTaskByCustomerId(customerid).getBody();
        List<InteractionRecord> interactionRecordList=(List<InteractionRecord>)
            interactionRecordService.getInteractionRecordByCustomerId(customerid).getBody();

        customerEventList.setOrderList(orderList);
        customerEventList.setInvoiceList(invoiceList);
        customerEventList.setPurchaseOrderList("");
        customerEventList.setQuotationList("");
        customerEventList.setServiceRequestList(serviceRequestList);
        customerEventList.setTaskList(taskList);
        customerEventList.setInteractionRecordList(interactionRecordList);


        CountInformation countInformation=new CountInformation();
      assert invoiceList != null;
      countInformation.setTotalInvoice(invoiceList.size());
      assert serviceRequestList != null;
      countInformation.setTotalServiceRequets(serviceRequestList.size());
      assert orderList != null;
      countInformation.setTotalOrders(orderList.size());


        customerDetailsResponse.setCount(countInformation);
        customerDetailsResponse.setEventList(customerEventList);
    }

    public ResponseEntity<CustomerDetailsResponse> getCustomerDetailsResponse(UUID customerid){
        CustomerDetailsResponse customerDetailsResponse=new CustomerDetailsResponse();
        customerDetailsResponse.setCustomer(customerRepository.findById(customerid)
            .orElseThrow(() -> new ResourceNotFoundException("Customer Not found")));
        customerDetailsResponse.setDueToday(DueToday());
        setCustomerEventList(customerid,customerDetailsResponse);
        return ResponseEntity.ok(customerDetailsResponse);
    }

}
