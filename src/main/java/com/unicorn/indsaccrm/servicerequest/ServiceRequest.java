package com.unicorn.indsaccrm.servicerequest;

import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicerequest")
public class ServiceRequest extends Auditable<String> {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID useradminid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID usercid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID customerid;

    @Column
    private String readstatus;

    @Column
    private String subject;

    @Column
    private String duedate;

    @Column
    private String priority;

    @Column
    private String notes;

    @Column
    private String status;

    @Column
    private String asignedto;

    @Column
    private String resolutionRemark;

    @Column
    private String resolutionNotes;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID resolutionUserId;

    @Column
    @Enumerated(EnumType.STRING)
    private ServiceRequestType serviceRequestType;

    enum ServiceRequestType {
        TechnicalSupportRequest,
        ProductInformationRequest,
        OrderStatusInquiry,
        BillingPaymentInquiry,
        ChangPersonalInformation,
        Complaints,
        CancellationReturnRequests,
        InstallationSetupAssistance,
        TroubleshootingAssistance,
        MaintenanceRepairRequest,
        FeedbackSuggestions,
        TrainingRequests,
        EmergencyUrgentRequests,
        InformationRequest,
        UpgradesRenewals,
        AccountAccess,
        LoginIssues,
        EscalationRequests
    }
}
