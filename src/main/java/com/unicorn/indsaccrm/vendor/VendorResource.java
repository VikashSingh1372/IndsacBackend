package com.unicorn.indsaccrm.vendor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.EnumMap;
import java.util.List;

public class VendorResource {

    enum VendorStatus {
    Active,InActive

    }

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
        private  EnumMap<VendorStatus,IntegerEnum> VendorCountByStatus;

        @Column
        private List<Vendor> VendorList;

        @Column
        private EnumMap<IntegerEnum,IntegerEnum> totalVendorInCurrentMonth;

        @Column
        private EnumMap<IntegerEnum,IntegerEnum> totalVendorAddedByMonthinCurrentYear;
    }
}
