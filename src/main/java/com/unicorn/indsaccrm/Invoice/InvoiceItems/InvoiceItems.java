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
@Table(name = "invoiceitems")
public class InvoiceItems extends Auditable<String> {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID item_id;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID invoice_id;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID product_id;

    @Column
    private int quantity;

    @Column
    private Double unit_price;

    @Column
    private Currencies currency;

    private enum Currencies {
        RUPEE,DOLLAR
    }
}