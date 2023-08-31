package com.unicorn.indsaccrm.defaultvalues;

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
@Table(name = "defaultvalues")
public class DefaultValues extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
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
    private  String invoicedefaultcity;

    @Column
    private  String sgst;

    @Column
    private String igst;

    @Column
    private String shippingcharge;

    @Column
    private String servicecharge;

    @Column
    private String discount;

    @Column
    private String frieghtchage;




}
