package com.unicorn.indsaccrm.lead;

import lombok.*;

import javax.persistence.*;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LeadResource {


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
    public static class LeadDashboard{

        @Column
        private long totalLead;

        @Column
        private long convertedLeads;

        @Column
        private long activeLead;

        @Column
        private long inActiveLead;

        @Column
        private EnumMap<Lead.LeadStatus, IntegerEnum> LeadCountByStatus;

        @Column
        private List<Lead> LeadList;

        @Column
        private EnumMap<IntegerEnum,IntegerEnum> totalLeadInCurrentMonth;

        @Column
        private EnumMap<IntegerEnum,IntegerEnum> totalLeadAddedByMonthinCurrentYear;
    }
}



