package com.unicorn.indsaccrm.Customer;

import com.unicorn.indsaccrm.Invoice.Invoices.Invoice;
import com.unicorn.indsaccrm.common.util.enums.Priority;
import com.unicorn.indsaccrm.interactionrecord.InteractionRecord;
import com.unicorn.indsaccrm.order.ProductOrder;
import com.unicorn.indsaccrm.servicerequest.ServiceRequest;
import com.unicorn.indsaccrm.task.Task;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class CustomerResource {
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CustomerDetailsResponse{
        private Customer customer;
        private CountInformation count;
        private List<DueToday> dueToday;
        private List<OpenItems> openItemsList;
        private CustomerEventList eventList;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CustomerEventList{

        private List<ProductOrder> orderList;
        private List<Invoice> invoiceList;
        private String purchaseOrderList;
        private String quotationList;
        private List<ServiceRequest> serviceRequestList;
        private List<Task> taskList;
        private List<InteractionRecord> interactionRecordList;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CountInformation{

        private int totalInvoice;
        private int totalServiceRequets;
        private Double duePayment;
        private int totalOrders;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DueToday{
        private String type;
        private String subject;
        private String status;
        private LocalDate duedate;
        private Priority priority;
        private UUID assigned;

    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OpenItems{
        private String type;
        private String subject;
        private String status;
        private LocalDate duedate;
        private Priority priority;
        private UUID assigned;
    }
}
