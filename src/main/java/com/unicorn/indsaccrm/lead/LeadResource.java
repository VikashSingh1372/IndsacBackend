package com.unicorn.indsaccrm.lead;

import lombok.*;

import javax.persistence.*;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LeadResource {

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LeadDashboard{


        private long totalLead;

        private long convertedLeads;

        private long activeLead;

        private long inActiveLead;

        private Map<Lead.LeadStatus,Long> LeadCountByStatus;

        private List<Lead> LeadList;

        private Map<Integer,Long> totalLeadInCurrentMonth;

        private  Map<Integer,Long> totalLeadAddedByMonthinCurrentYear;
    }

}



