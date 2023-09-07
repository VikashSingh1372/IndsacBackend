package com.unicorn.indsaccrm.order;

import com.unicorn.indsaccrm.common.config.Auditable;
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
    private String totalprice;

    @Column
    private String status;

    @Column
    private String orderDate;

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
}
