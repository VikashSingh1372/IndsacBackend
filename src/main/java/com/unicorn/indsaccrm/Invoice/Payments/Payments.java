package com.unicorn.indsaccrm.Invoice.Payments;

import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "payments")
public class Payments extends Auditable<String> {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID paymentid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID invoiceid;

    @Column
    private String paymentdate;

    @Column
    private Double amount;

}