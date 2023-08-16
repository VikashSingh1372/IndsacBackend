package com.unicorn.indsaccrm.lead;

import lombok.*;

import javax.persistence.*;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LeadResource {

    enum LeadStatus{
        ACTIVE,INACTIVE
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
    public static class LeadDashboard{

        @Column
        private int totalLead;

        @Column
        private int convertedLeads;

        @Column
        private int activeLead;

        @Column
        private int inActiveLead;

        @Column
        private EnumMap<LeadStatus, IntegerEnum> LeadCountByStatus;

        @Column
        private List<Lead> LeadList;

        @Column
        private EnumMap<IntegerEnum,IntegerEnum> totalLeadInCurrentMonth;

        @Column
        private EnumMap<IntegerEnum,IntegerEnum> totalLeadAddedByMonthinCurrentYear;
    }
}



