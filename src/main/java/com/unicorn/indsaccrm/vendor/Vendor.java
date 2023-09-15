package com.unicorn.indsaccrm.vendor;

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
@Table(name = "vendor")
public class Vendor extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column
    private String readstatus;

    @Column
    private String companyname;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String leadsource;

    @Column
    private String status;

    @Column
    private String website;

    @Column
    private String bestwaycontact;

    @Column
    private String mobile;

    @Column
    private String altphone;

    @Column
    private String email;

    @Column
    private String add1;

    @Column
    private String add2;

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
    private String owner;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;

    enum VendorStatus{
        OPEN,ATTEMPTEDCONTACT,NOTENGAGED,NEEDSFOLLOWUP,WORKING,NEWOPPORTUNITY,QUALIFIED,DISQUALIFIED,CONVERTTOCUSTOMER
    }

}
