package com.unicorn.indsaccrm.Invoice.InvoiceItems;

import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "invoiceitem")
public class InvoiceItems extends Auditable<String> {

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
    private UUID invoiceid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID productid;

    @Column
    private int quantity;

    @Column
    private Double unitprice;

    @Column
    private Currencies currency;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID owner;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID usercid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID useradminid;

    private enum Currencies {
        RUPEE,DOLLAR
    }
}