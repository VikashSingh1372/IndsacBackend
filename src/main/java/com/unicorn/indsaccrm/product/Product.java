package com.unicorn.indsaccrm.product;

import com.unicorn.indsaccrm.config.Auditable;
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
@Table(name = "product")
public class Product extends Auditable<String> {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUDi",
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
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID invoiceid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID contactid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID stockid;

    @Column
    private String vendor;

    @Column
    private String owner_;

    @Column
    private String productname;

    @Column
    private String productcode;

    @Column
    private String productcategory;

    @Column
    private String productstatus;

    @Column
    private String buyingprice;

    @Column
    private String sellingprice;

    @Column
    private String quantity;

    @Column
    private String altphone;

    @Column
    private String billnumber;

    @Column
    private String totalamount;

    @Column
    private String add2;

    @Column
    private String add3;

    @Column
    private String city;

    @Column
    private String pincode;

    @Column
    private String state;

    @Column
    private String country;

    @Column
    private String notes;

    @Column
    private String product;

    @Column
    private String type;
}
