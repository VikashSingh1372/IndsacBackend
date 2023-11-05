package com.unicorn.indsaccrm.order;

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
@Table(name = "productorder")
public class ProductOrder extends Auditable<String> {
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
    private Priority priority;

    @Column
    private String totalprice;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column
    private LocalDate orderDate;// "Year-Month-Date"

    @Column
    private LocalDate duedate; // "Year-Month-Date"

    @Column
    private String paymentMethod;

    //invoice id will be generated once payment is confirmed
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID invoiceId;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID shippingAddressId;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID billingAddressId;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID customerId;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID asignedto;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID leadid;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID vendorid;

    public enum OrderStatus{
        Pending,Processing,InTransit,OutforDelivery,Delivered,Cancelled,OnHold,Returned,PartiallyShipped,
        Refunded,AwaitingPayment,Backordered
    }
}
