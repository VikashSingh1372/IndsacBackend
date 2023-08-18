package com.unicorn.indsaccrm.lead;

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
@Table(name = "lead")
public class Lead extends Auditable<String> {
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
    @Enumerated(EnumType.STRING)
    private LeadStatus status;

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
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID owner;

    enum LeadStatus{
        OPEN,ATTEMPTEDCONTACT,NOTENGAGED,NEEDSFOLLOWUP,WORKING,NEWOPPORTUNITY,QUALIFIED,DISQUALIFIED,CONVERTTOCUSTOMER
    }

}
