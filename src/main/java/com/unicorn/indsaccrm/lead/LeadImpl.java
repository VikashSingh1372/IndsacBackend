package com.unicorn.indsaccrm.lead;

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
import java.time.LocalDate;
import java.util.*;

@Service
public class LeadImpl implements LeadService{
    @Autowired
    LeadRepository leadRepository;

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
        Root<Lead> root = query.from(Lead.class);
        query.select(cb.tuple(root.get("useradminid"),
                cb.count(root.get("useradminid"))));
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
        Root<Lead> root = query.from(Lead.class);
        query.select(cb.tuple(cb.function("MONTH", Integer.class, root.get("creationDate") ),
                cb.count(root.get("id"))));
        //Predicate currentMonthPredicate=cb.equal(cb.function("MONTH", Integer.class, root.get("creationDate") ),cb.function("MONTH", Integer.class, cb.currentTimestamp()));
        Predicate currentYearPredicate=cb.equal(cb.function("YEAR", Integer.class, root.get("creationDate") ),cb.function("YEAR", Integer.class, cb.currentTimestamp() ));
        Predicate useradminidPredicate=cb.equal( root.get("useradminid"),useradminid);
        query.where(currentYearPredicate,useradminidPredicate);
        query.groupBy(cb.function("MONTH", Integer.class, root.get("creationDate") ));
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

    //Set Values for DueToday
    public List<LeadDetails.DueToday> getDueToday(UUID leadid, UUID useradminid){
        List<Invoice> invoiceList=invoicesService.getAllInvoicesByDueDateAndStatusNotIn(leadid,useradminid, LocalDate.now(),
                Arrays.asList(Invoice.InvoiceStatus.Canceled, Invoice.InvoiceStatus.Closed, Invoice.InvoiceStatus.Paid)).getBody();

        List<Task> taskList=taskService.getAllTaskByDueDateAndStatusNotIn(leadid,useradminid,
                        LocalDate.now(), Arrays.asList(Task.TaskStatus.Canceled, Task.TaskStatus.Completed, Task.TaskStatus.Closed))
                .getBody();
        List<ProductOrder> orderList=productOrderService.getProductOrderByDueDateAndStatusNotIn(leadid,useradminid,LocalDate.now(),Arrays.asList(
                ProductOrder.OrderStatus.Cancelled, ProductOrder.OrderStatus.Delivered)).getBody();
        List<ServiceRequest> serviceRequestList=serviceRequestService.getServiceRequestByDueDateAndStatusNotIn(useradminid,leadid,LocalDate.now(),
                Arrays.asList(ServiceRequest.ServiceRequestStatus.Closed, ServiceRequest.ServiceRequestStatus.Canceled)).getBody();


        List<LeadDetails.DueToday> dueTodayList=new ArrayList<>();
        invoiceList.forEach(invoice -> {
            LeadDetails.DueToday dueToday=new LeadDetails.DueToday();
            dueToday.setType("Invoice");
            dueToday.setSubject(invoice.getSubject());
            dueToday.setStatus(invoice.getStatus().toString());
            dueToday.setDuedate(invoice.getDuedate());
            dueToday.setPriority(invoice.getPriority());
            dueToday.setAssigned(invoice.getAsignedto());
            dueTodayList.add(dueToday);
        });

        orderList.forEach(productOrder -> {
            LeadDetails.DueToday dueToday=new LeadDetails.DueToday();
            dueToday.setType("Order");
            dueToday.setSubject(productOrder.getSubject());
            dueToday.setStatus(productOrder.getStatus().toString());
            dueToday.setDuedate(productOrder.getDuedate());
            dueToday.setPriority(productOrder.getPriority());
            dueToday.setAssigned(productOrder.getAsignedto());
            dueTodayList.add(dueToday);
        });
        taskList.forEach(task -> {
            LeadDetails.DueToday dueToday=new LeadDetails.DueToday();
            dueToday.setType("Task");
            dueToday.setSubject(task.getSubject());
            dueToday.setStatus(task.getStatus().toString());
            dueToday.setDuedate(task.getDuedate());
            dueToday.setPriority(task.getPriority());
            dueToday.setAssigned(task.getAsignedto());
            dueTodayList.add(dueToday);
        });

        serviceRequestList.forEach(serviceRequest -> {
            LeadDetails.DueToday dueToday=new LeadDetails.DueToday();
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
    public List<LeadDetails.OpenItems> getOpenItems(UUID leadid, UUID useradminid){
        List<Invoice> invoiceList=invoicesService.getAllInvoicesByStatusNotIn(leadid,useradminid,
                Arrays.asList(Invoice.InvoiceStatus.Canceled, Invoice.InvoiceStatus.Closed, Invoice.InvoiceStatus.Paid)).getBody();

        List<Task> taskList=taskService.getAllTaskByStatusNotIn(leadid,useradminid,
                        Arrays.asList(Task.TaskStatus.Canceled, Task.TaskStatus.Completed, Task.TaskStatus.Closed))
                .getBody();
        List<ProductOrder> orderList=productOrderService.getProductOrderByStatusNotIn(leadid,useradminid,
                Arrays.asList(ProductOrder.OrderStatus.Cancelled, ProductOrder.OrderStatus.Delivered)).getBody();
        List<ServiceRequest> serviceRequestList=serviceRequestService.getServiceRequestByStatusNotIn(
                useradminid,leadid, Arrays.asList(ServiceRequest.ServiceRequestStatus.Closed,
                        ServiceRequest.ServiceRequestStatus.Canceled)).getBody();


        List<LeadDetails.OpenItems> openItemsList=new ArrayList<>();
        invoiceList.forEach(invoice -> {
            LeadDetails.OpenItems openItems=new LeadDetails.OpenItems();
            openItems.setType("Invoice");
            openItems.setSubject(invoice.getSubject());
            openItems.setStatus(invoice.getStatus().toString());
            openItems.setDuedate(invoice.getDuedate());
            openItems.setPriority(invoice.getPriority());
            openItems.setAssigned(invoice.getAsignedto());
            openItemsList.add(openItems);
        });

        orderList.forEach(productOrder -> {
            LeadDetails.OpenItems openItems=new LeadDetails.OpenItems();
            openItems.setType("Order");
            openItems.setSubject(productOrder.getSubject());
            openItems.setStatus(productOrder.getStatus().toString());
            openItems.setDuedate(productOrder.getDuedate());
            openItems.setPriority(productOrder.getPriority());
            openItems.setAssigned(productOrder.getAsignedto());
            openItemsList.add(openItems);
        });
        taskList.forEach(task -> {
            LeadDetails.OpenItems openItems=new LeadDetails.OpenItems();;
            openItems.setType("Task");
            openItems.setSubject(task.getSubject());
            openItems.setStatus(task.getStatus().toString());
            openItems.setDuedate(task.getDuedate());
            openItems.setPriority(task.getPriority());
            openItems.setAssigned(task.getAsignedto());
            openItemsList.add(openItems);
        });

        serviceRequestList.forEach(serviceRequest -> {
            LeadDetails.OpenItems openItems=new LeadDetails.OpenItems();
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

    public void setLeadEventList(UUID leadid,
                                     LeadDetails.LeadDetailsResponse leadDetailsResponse){
        LeadDetails.LeadEventList leadEventList=new LeadDetails.LeadEventList();

        List<Invoice> invoiceList= (List<Invoice>) invoicesService.getInvoicesByLeadid(leadid).getBody();
        List<ProductOrder> orderList=(List<ProductOrder>) productOrderService.getProductOrderByUserLeadid(leadid).getBody();

        List<ServiceRequest> serviceRequestList=(List<ServiceRequest>) serviceRequestService
                .getServiceRequestByLeadid(leadid).getBody();
        List<Task> taskList=(List<Task>) taskService.getTaskByLeadid(leadid).getBody();
        List<InteractionRecord> interactionRecordList=(List<InteractionRecord>)
                interactionRecordService.getInteractionRecordByLeadid(leadid).getBody();

        leadEventList.setOrderList(orderList);
        leadEventList.setInvoiceList(invoiceList);
        leadEventList.setPurchaseOrderList("");
        leadEventList.setQuotationList("");
        leadEventList.setServiceRequestList(serviceRequestList);
        leadEventList.setTaskList(taskList);
        leadEventList.setInteractionRecordList(interactionRecordList);


        LeadDetails.CountInformation countInformation=new LeadDetails.CountInformation();
        assert invoiceList != null;
        countInformation.setTotalInvoice(invoiceList.size());
        assert serviceRequestList != null;
        countInformation.setTotalServiceRequets(serviceRequestList.size());
        assert orderList != null;
        countInformation.setTotalOrders(orderList.size());

        leadDetailsResponse.setCount(countInformation);
        leadDetailsResponse.setEventList(leadEventList);
    }

    @Override
    public ResponseEntity<LeadDetails.LeadDetailsResponse> getLeadDetailsResponse(UUID leadid) {
        LeadDetails.LeadDetailsResponse leadDetailsResponse = new LeadDetails.LeadDetailsResponse();
        Lead lead = leadRepository.findById(leadid)
                .orElseThrow(() -> new ResourceNotFoundException("Lead Not found"));
        leadDetailsResponse.setLead(lead);
        leadDetailsResponse.setDueToday(getDueToday(leadid, lead.getUseradminid()));
        leadDetailsResponse.setOpenItemsList(getOpenItems(leadid, lead.getUseradminid()));
        setLeadEventList(leadid,leadDetailsResponse);
        return ResponseEntity.ok(leadDetailsResponse);
    }
}
