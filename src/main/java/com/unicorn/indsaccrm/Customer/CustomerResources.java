package com.unicorn.indsaccrm.Customer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;;
import java.util.List;
import java.util.Map;

public class CustomerResources {

    enum IntegerEnum{

        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10);


        private final int value;

    private IntegerEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CustomerDashboard{
        @Column
        private long totalCustomer;

        @Column
        private long convertedCustomer;

        @Column
        private long activeCustomer;

        @Column
        private long inActiveCustomer;

        @Column
        private Map<Customer.CustomerStatus, Long> customerCountByStatus;

        @Column
        private List<Customer> customerList;

        @Column
        private Map<Integer,Long> totalCustomerInCurrentMonth;

        @Column
        private Map<Integer,Long> totalCustomerAddedByMonthInCurrentYear;



    }

}
