package com.unicorn.indsaccrm.Invoice.Invoices;

import com.unicorn.indsaccrm.Invoice.Customer.Customer;
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
@Table(name = "inovices")
public class Invoices extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID invoiceid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID customerid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID userid;
}

