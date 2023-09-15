package com.unicorn.indsaccrm.vendor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class VendorResource {


    enum IntegerEnum {
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
    public static class VendorDashboard{

        @Column
        private long totalVendor;

        @Column
        private long activeVendor;

        @Column
        private long inActiveVendor;

        @Column
        private Map<Vendor.VendorStatus,Long> VendorCountByStatus;

        @Column
        private List<Vendor> VendorList;

        @Column
        private Map<Integer,Long> totalVendorInCurrentMonth;

        @Column
        private Map<Integer,Long> totalVendorAddedByMonthinCurrentYear;
    }
}
