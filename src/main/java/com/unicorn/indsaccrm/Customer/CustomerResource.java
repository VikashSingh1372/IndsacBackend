package com.unicorn.indsaccrm.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CustomerResource {


    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CustomerInformation{

        private String orderList;
        private String invoiceList;
        private String purchaseOrderList;
        private String quotationList;
        private String serviceRequestList;
        private String taskList;
        private String interactionRecordList;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CountInformation{

        private String totalInvoice;
        private String duePayment;
        private String totalOrders;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DueToday{

        private String order;
        private String invoice;
        private String task;
        private String serviceRequest;
        private String interactionRecord;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OpenItems{

        private String order;
        private String invoice;
        private String task;
        private String serviceRequest;
        private String interactionRecord;
    }
}
