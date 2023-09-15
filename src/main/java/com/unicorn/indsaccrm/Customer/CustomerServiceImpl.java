package com.unicorn.indsaccrm.Customer;

import com.unicorn.indsaccrm.Customer.CustomerResource.CountInformation;
import com.unicorn.indsaccrm.Customer.CustomerResource.CustomerDetailsResponse;
import com.unicorn.indsaccrm.Customer.CustomerResource.DueToday;
import com.unicorn.indsaccrm.Customer.CustomerResource.OpenItems;
import com.unicorn.indsaccrm.Invoice.Invoices.Invoice;
import com.unicorn.indsaccrm.Invoice.Invoices.Invoice.InvoiceStatus;
import com.unicorn.indsaccrm.Invoice.Invoices.InvoicesService;
import com.unicorn.indsaccrm.common.exception.ResourceNotFoundException;
import com.unicorn.indsaccrm.interactionrecord.InteractionRecord;
import com.unicorn.indsaccrm.interactionrecord.InteractionRecordService;
import com.unicorn.indsaccrm.order.ProductOrder;
import com.unicorn.indsaccrm.order.ProductOrder.OrderStatus;
import com.unicorn.indsaccrm.order.ProductOrderService;
import com.unicorn.indsaccrm.servicerequest.ServiceRequest;
import com.unicorn.indsaccrm.servicerequest.ServiceRequest.ServiceRequestStatus;
import com.unicorn.indsaccrm.servicerequest.ServiceRequestService;
import com.unicorn.indsaccrm.task.Task;
import com.unicorn.indsaccrm.task.Task.TaskStatus;
import com.unicorn.indsaccrm.task.TaskService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
    public List<DueToday> getDueToday(UUID customerId,UUID useradminid){
        List<Invoice> invoiceList=invoicesService.getAllInvoicesByDueDateAndStatusNotIn(customerId,useradminid,LocalDate.now(),
            Arrays.asList(InvoiceStatus.Canceled,InvoiceStatus.Closed,InvoiceStatus.Paid)).getBody();

        List<Task> taskList=taskService.getAllTaskByDueDateAndStatusNotIn(customerId,useradminid,
            LocalDate.now(), Arrays.asList(TaskStatus.Canceled,TaskStatus.Completed,TaskStatus.Closed))
            .getBody();
        List<ProductOrder> orderList=productOrderService.getProductOrderByDueDateAndStatusNotIn(customerId,useradminid,LocalDate.now(),Arrays.asList(
            OrderStatus.Cancelled,OrderStatus.Delivered)).getBody();
        List<ServiceRequest> serviceRequestList=serviceRequestService.getServiceRequestByDueDateAndStatusNotIn(useradminid,customerId,LocalDate.now(),
            Arrays.asList(ServiceRequestStatus.Closed,ServiceRequestStatus.Canceled)).getBody();


        List<DueToday> dueTodayList=new ArrayList<>();
        invoiceList.forEach(invoice -> {
            DueToday dueToday=new DueToday();
            dueToday.setType("Invoice");
            dueToday.setSubject(invoice.getSubject());
            dueToday.setStatus(invoice.getStatus().toString());
            dueToday.setDuedate(invoice.getDuedate());
            dueToday.setPriority(invoice.getPriority());
            dueToday.setAssigned(invoice.getAsignedto());
            dueTodayList.add(dueToday);
        });

        orderList.forEach(productOrder -> {
            DueToday dueToday=new DueToday();
            dueToday.setType("Order");
            dueToday.setSubject(productOrder.getSubject());
            dueToday.setStatus(productOrder.getStatus().toString());
            dueToday.setDuedate(productOrder.getDuedate());
            dueToday.setPriority(productOrder.getPriority());
            dueToday.setAssigned(productOrder.getAsignedto());
            dueTodayList.add(dueToday);
        });
        taskList.forEach(task -> {
            DueToday dueToday=new DueToday();
            dueToday.setType("Task");
            dueToday.setSubject(task.getSubject());
            dueToday.setStatus(task.getStatus().toString());
            dueToday.setDuedate(task.getDuedate());
            dueToday.setPriority(task.getPriority());
            dueToday.setAssigned(task.getAsignedto());
            dueTodayList.add(dueToday);
        });

        serviceRequestList.forEach(serviceRequest -> {
            DueToday dueToday=new DueToday();
            dueToday.setType("Service Request");
            dueToday.setSubject(serviceRequest.getSubject());
            dueToday.setStatus(serviceRequest.getStatus().toString());
            dueToday.setDuedate(serviceRequest.getDuedate());
            dueToday.setPriority(serviceRequest.getPriority());
            dueToday.setAssigned(serviceRequest.getAsignedto());
            dueTodayList.add(dueToday);
        });

        return dueTodayList;
    }

    //Set Values for OpenItems
    public List<OpenItems> getOpenItems(UUID customerId,UUID useradminid){
        List<Invoice> invoiceList=invoicesService.getAllInvoicesByStatusNotIn(customerId,useradminid,
            Arrays.asList(InvoiceStatus.Canceled,InvoiceStatus.Closed,InvoiceStatus.Paid)).getBody();

        List<Task> taskList=taskService.getAllTaskByStatusNotIn(customerId,useradminid,
                Arrays.asList(TaskStatus.Canceled,TaskStatus.Completed,TaskStatus.Closed))
            .getBody();
        List<ProductOrder> orderList=productOrderService.getProductOrderByStatusNotIn(customerId,useradminid,
            Arrays.asList(OrderStatus.Cancelled,OrderStatus.Delivered)).getBody();
        List<ServiceRequest> serviceRequestList=serviceRequestService.getServiceRequestByStatusNotIn(
            useradminid,customerId, Arrays.asList(ServiceRequestStatus.Closed,
                ServiceRequestStatus.Canceled)).getBody();


        List<OpenItems> openItemsList=new ArrayList<>();
        invoiceList.forEach(invoice -> {
            OpenItems openItems=new OpenItems();
            openItems.setType("Invoice");
            openItems.setSubject(invoice.getSubject());
            openItems.setStatus(invoice.getStatus().toString());
            openItems.setDuedate(invoice.getDuedate());
            openItems.setPriority(invoice.getPriority());
            openItems.setAssigned(invoice.getAsignedto());
            openItemsList.add(openItems);
        });

        orderList.forEach(productOrder -> {
            OpenItems openItems=new OpenItems();
            openItems.setType("Order");
            openItems.setSubject(productOrder.getSubject());
            openItems.setStatus(productOrder.getStatus().toString());
            openItems.setDuedate(productOrder.getDuedate());
            openItems.setPriority(productOrder.getPriority());
            openItems.setAssigned(productOrder.getAsignedto());
            openItemsList.add(openItems);
        });
        taskList.forEach(task -> {
            OpenItems openItems=new OpenItems();;
            openItems.setType("Task");
            openItems.setSubject(task.getSubject());
            openItems.setStatus(task.getStatus().toString());
            openItems.setDuedate(task.getDuedate());
            openItems.setPriority(task.getPriority());
            openItems.setAssigned(task.getAsignedto());
            openItemsList.add(openItems);
        });

        serviceRequestList.forEach(serviceRequest -> {
            OpenItems openItems=new OpenItems();
            openItems.setType("Service Request");
            openItems.setSubject(serviceRequest.getSubject());
            openItems.setStatus(serviceRequest.getStatus().toString());
            openItems.setDuedate(serviceRequest.getDuedate());
            openItems.setPriority(serviceRequest.getPriority());
            openItems.setAssigned(serviceRequest.getAsignedto());
            openItemsList.add(openItems);
        });
        return openItemsList;
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
        Customer customer=customerRepository.findById(customerid)
            .orElseThrow(() -> new ResourceNotFoundException("Customer Not found"));
        customerDetailsResponse.setCustomer(customer);
        customerDetailsResponse.setDueToday(getDueToday(customerid,customer.getUseradminid()));
        customerDetailsResponse.setOpenItemsList(getOpenItems(customerid,customer.getUseradminid()));
        setCustomerEventList(customerid,customerDetailsResponse);
        return ResponseEntity.ok(customerDetailsResponse);
    }

}
