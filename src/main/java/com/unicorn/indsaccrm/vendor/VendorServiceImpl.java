package com.unicorn.indsaccrm.vendor;


import com.unicorn.indsaccrm.Invoice.Invoices.Invoice;
import com.unicorn.indsaccrm.Invoice.Invoices.InvoicesService;
import com.unicorn.indsaccrm.common.exception.ResourceNotFoundException;
import com.unicorn.indsaccrm.interactionrecord.InteractionRecord;
import com.unicorn.indsaccrm.interactionrecord.InteractionRecordService;
import com.unicorn.indsaccrm.lead.Lead;
import com.unicorn.indsaccrm.lead.LeadDetails;
import com.unicorn.indsaccrm.order.ProductOrder;
import com.unicorn.indsaccrm.order.ProductOrderService;
import com.unicorn.indsaccrm.servicerequest.ServiceRequest;
import com.unicorn.indsaccrm.servicerequest.ServiceRequestService;
import com.unicorn.indsaccrm.task.Task;
import com.unicorn.indsaccrm.task.TaskService;
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
import java.time.LocalDate;
import java.util.*;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    InvoicesService invoicesService;

    @Autowired
    ProductOrderService productOrderService;

    @Autowired
    ServiceRequestService serviceRequestService;

    @Autowired
    TaskService taskService;

    @Autowired
    InteractionRecordService interactionRecordService;

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
        vendorDashboard.setVendorList(vendorRepository.findByUseradminid(useradminid));
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

    //Set Values for DueToday
    public List<VendorDetails.DueToday> getDueToday(UUID vendorid, UUID useradminid){
        List<Invoice> invoiceList=invoicesService.getAllInvoicesByDueDateAndStatusNotIn(vendorid,useradminid, LocalDate.now(),
                Arrays.asList(Invoice.InvoiceStatus.Canceled, Invoice.InvoiceStatus.Closed, Invoice.InvoiceStatus.Paid)).getBody();

        List<Task> taskList=taskService.getAllTaskByDueDateAndStatusNotIn(vendorid,useradminid,
                        LocalDate.now(), Arrays.asList(Task.TaskStatus.Canceled, Task.TaskStatus.Completed, Task.TaskStatus.Closed))
                .getBody();
        List<ProductOrder> orderList=productOrderService.getProductOrderByDueDateAndStatusNotIn(vendorid,useradminid,LocalDate.now(),Arrays.asList(
                ProductOrder.OrderStatus.Cancelled, ProductOrder.OrderStatus.Delivered)).getBody();
        List<ServiceRequest> serviceRequestList=serviceRequestService.getServiceRequestByDueDateAndStatusNotIn(useradminid,vendorid,LocalDate.now(),
                Arrays.asList(ServiceRequest.ServiceRequestStatus.Closed, ServiceRequest.ServiceRequestStatus.Canceled)).getBody();


        List<VendorDetails.DueToday> dueTodayList=new ArrayList<>();
        invoiceList.forEach(invoice -> {
            VendorDetails.DueToday dueToday=new VendorDetails.DueToday();
            dueToday.setType("Invoice");
            dueToday.setSubject(invoice.getSubject());
            dueToday.setStatus(invoice.getStatus().toString());
            dueToday.setDuedate(invoice.getDuedate());
            dueToday.setPriority(invoice.getPriority());
            dueToday.setAssigned(invoice.getAsignedto());
            dueTodayList.add(dueToday);
        });

        orderList.forEach(productOrder -> {
            VendorDetails.DueToday dueToday=new VendorDetails.DueToday();
            dueToday.setType("Order");
            dueToday.setSubject(productOrder.getSubject());
            dueToday.setStatus(productOrder.getStatus().toString());
            dueToday.setDuedate(productOrder.getDuedate());
            dueToday.setPriority(productOrder.getPriority());
            dueToday.setAssigned(productOrder.getAsignedto());
            dueTodayList.add(dueToday);
        });
        taskList.forEach(task -> {
            VendorDetails.DueToday dueToday=new VendorDetails.DueToday();
            dueToday.setType("Task");
            dueToday.setSubject(task.getSubject());
            dueToday.setStatus(task.getStatus().toString());
            dueToday.setDuedate(task.getDuedate());
            dueToday.setPriority(task.getPriority());
            dueToday.setAssigned(task.getAsignedto());
            dueTodayList.add(dueToday);
        });

        serviceRequestList.forEach(serviceRequest -> {
            VendorDetails.DueToday dueToday=new VendorDetails.DueToday();
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
    //Set Values for
    public List<VendorDetails.OpenItems> getOpenItems(UUID vendorid, UUID useradminid){
        List<Invoice> invoiceList=invoicesService.getAllInvoicesByStatusNotIn(vendorid,useradminid,
                Arrays.asList(Invoice.InvoiceStatus.Canceled, Invoice.InvoiceStatus.Closed, Invoice.InvoiceStatus.Paid)).getBody();

        List<Task> taskList=taskService.getAllTaskByStatusNotIn(vendorid,useradminid,
                        Arrays.asList(Task.TaskStatus.Canceled, Task.TaskStatus.Completed, Task.TaskStatus.Closed))
                .getBody();
        List<ProductOrder> orderList=productOrderService.getProductOrderByStatusNotIn(vendorid,useradminid,
                Arrays.asList(ProductOrder.OrderStatus.Cancelled, ProductOrder.OrderStatus.Delivered)).getBody();
        List<ServiceRequest> serviceRequestList=serviceRequestService.getServiceRequestByStatusNotIn(
                useradminid,vendorid, Arrays.asList(ServiceRequest.ServiceRequestStatus.Closed,
                        ServiceRequest.ServiceRequestStatus.Canceled)).getBody();


        List<VendorDetails.OpenItems> openItemsList=new ArrayList<>();
        invoiceList.forEach(invoice -> {
            VendorDetails.OpenItems openItems=new VendorDetails.OpenItems();
            openItems.setType("Invoice");
            openItems.setSubject(invoice.getSubject());
            openItems.setStatus(invoice.getStatus().toString());
            openItems.setDuedate(invoice.getDuedate());
            openItems.setPriority(invoice.getPriority());
            openItems.setAssigned(invoice.getAsignedto());
            openItemsList.add(openItems);
        });

        orderList.forEach(productOrder -> {
            VendorDetails.OpenItems openItems=new VendorDetails.OpenItems();
            openItems.setType("Order");
            openItems.setSubject(productOrder.getSubject());
            openItems.setStatus(productOrder.getStatus().toString());
            openItems.setDuedate(productOrder.getDuedate());
            openItems.setPriority(productOrder.getPriority());
            openItems.setAssigned(productOrder.getAsignedto());
            openItemsList.add(openItems);
        });
        taskList.forEach(task -> {
            VendorDetails.OpenItems openItems=new VendorDetails.OpenItems();;
            openItems.setType("Task");
            openItems.setSubject(task.getSubject());
            openItems.setStatus(task.getStatus().toString());
            openItems.setDuedate(task.getDuedate());
            openItems.setPriority(task.getPriority());
            openItems.setAssigned(task.getAsignedto());
            openItemsList.add(openItems);
        });

        serviceRequestList.forEach(serviceRequest -> {
            VendorDetails.OpenItems openItems=new VendorDetails.OpenItems();
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

    public void setVendorEventList(UUID vendorid,
                                 VendorDetails.VendorDetailsResponse vendorDetailsResponse){
        VendorDetails.VendorEventList vendorEventList=new VendorDetails.VendorEventList();

        List<Invoice> invoiceList= (List<Invoice>) invoicesService.getInvoicesByVendorid(vendorid).getBody();
        List<ProductOrder> orderList=(List<ProductOrder>) productOrderService.getProductOrderByUserVendorid(vendorid).getBody();

        List<ServiceRequest> serviceRequestList=(List<ServiceRequest>) serviceRequestService
                .getServiceRequestByVedorid(vendorid).getBody();
        List<Task> taskList=(List<Task>) taskService.getTaskByVendorid(vendorid).getBody();
        List<InteractionRecord> interactionRecordList=(List<InteractionRecord>)
                interactionRecordService.getInteractionRecordByVendorid(vendorid).getBody();

        vendorEventList.setOrderList(orderList);
        vendorEventList.setInvoiceList(invoiceList);
        vendorEventList.setPurchaseOrderList("");
        vendorEventList.setQuotationList("");
        vendorEventList.setServiceRequestList(serviceRequestList);
        vendorEventList.setTaskList(taskList);
        vendorEventList.setInteractionRecordList(interactionRecordList);


        VendorDetails.CountInformation countInformation=new VendorDetails.CountInformation();
        assert invoiceList != null;
        countInformation.setTotalInvoice(invoiceList.size());
        assert serviceRequestList != null;
        countInformation.setTotalServiceRequets(serviceRequestList.size());
        assert orderList != null;
        countInformation.setTotalOrders(orderList.size());
        vendorDetailsResponse.setCount(countInformation);
        vendorDetailsResponse.setEventList(vendorEventList);
    }

    @Override
    public ResponseEntity<VendorDetails.VendorDetailsResponse> getVendorDetailsResponse(UUID vendorid) {
        VendorDetails.VendorDetailsResponse vendorDetailsResponse = new VendorDetails.VendorDetailsResponse();
        Vendor vendor = vendorRepository.findById(vendorid)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor Not found"));
        vendorDetailsResponse.setVendor(vendor);
        vendorDetailsResponse.setDueToday(getDueToday(vendorid, vendor.getUseradminid()));
        vendorDetailsResponse.setOpenItemsList(getOpenItems(vendorid, vendor.getUseradminid()));
        setVendorEventList(vendorid,vendorDetailsResponse);
        return ResponseEntity.ok(vendorDetailsResponse);
    }

}

