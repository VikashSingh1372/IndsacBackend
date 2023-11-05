package com.unicorn.indsaccrm.Invoice.Invoices;

import com.unicorn.indsaccrm.common.config.Auditable;
import com.unicorn.indsaccrm.common.util.enums.Priority;
import java.time.LocalDate;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "invoice")
public class Invoice extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column
    private String subject;

    @Column
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID customerid;

    @Column
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column
    private Double invoicetotalamount;

    @Column
    private Double totalpaidamount;

    @Column
    private LocalDate duedate; // "Year-Month-Date"

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID owner;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID usercid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID useradminid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID leadid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID vendorid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID asignedto;

    public enum InvoiceStatus{
        Draft,Pending,Paid,Overdue,Canceled,PartiallyPaid,PendingApproval,Sent,Closed,OnHold
    }
    /*
Invoice statuses you might find in a CRM system:

Draft: An invoice is in the draft status when it has been created but not yet finalized. This means it may still be edited or reviewed before sending it to the customer.

Pending: This status indicates that the invoice has been sent to the customer but has not been paid yet. It is awaiting payment confirmation.

Paid: When the customer has successfully paid the invoice, it is marked as "Paid." This status confirms that the transaction is complete.

Overdue: An invoice becomes overdue when the payment due date has passed, and the customer has not yet made the payment. This status is often accompanied by automated reminders or follow-up actions.

Canceled: If an invoice is no longer valid or needs to be voided for some reason, it can be marked as "Canceled." This status indicates that the invoice is no longer in effect.

Partially Paid: In some cases, a customer may make a partial payment towards an invoice. The invoice status would then be "Partially Paid," indicating that a portion of the total amount has been received.

Pending Approval: In larger organizations, invoices may need approval from supervisors or managers before they can be sent to customers. "Pending Approval" status indicates that the invoice is awaiting internal approval.

Sent: This status means that the invoice has been generated and sent to the customer but has not yet been paid or marked as paid. It's an interim status before "Paid" or "Pending."

Closed: Some CRMs may use the "Closed" status to indicate that the invoice has been paid in full and all associated transactions and records have been reconciled and closed.

On Hold: In situations where there might be a delay or issue with the invoice, it can be put "On Hold." This status indicates that there are outstanding issues that need to be resolved before proceeding.
     */
}

