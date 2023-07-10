package com.unicorn.indsaccrm.admindefaultvalues;

import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="admindefaultvalues")
public class AdminDefaultValues extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;

    @Column
    private String invoiceformat;

    @Column
    private String invoicelogofile;

    @Column
    private String businesslogofile;

    @Column
    private String currency;

    @Column
    private String servicecharge;

    @Column
    private String discount;
    @Column
    private String frieghtcharge;

    @Column
    private String esi_sellername;

    @Column
    private String esi_contactfirstname;

    @Column
    private String esi_contactlastname;

    @Column
    private String subcategory;

    @Column
    private String esi_gst;

    @Column
    private String esi_website;

    @Column
    private String esi_mobile;


    @Column
    private String esi_alternatephone;

    @Column
    private String esi_email;

    @Column
    private String esi_address1;

    @Column
    private String esi_address2;

    @Column
    private String esi_address3;

    @Column
    private String esi_city;

    @Column
    private String esi_pincode;

    @Column
    private String esi_state;

    @Column
    private String esi_country;

    @Column
    private String etc_line1;

    @Column
    private String etc_line2;

    @Column
    private String etc_line3;

    @Column
    private String etc_line4;

    @Column
    private String n_heading;

    @Column
    private String n_line1;

    @Column
    private String n_line2;

    @Column
    private String n_line3;

    @Column
    private String n_line4;

    @Column
    private String gst;

    @Column
    private String notes;

    @Column
    private String default123;

    @Column
    private String bankname;

    @Column
    private String bankacno;

    @Column
    private String bankadd;

    @Column
    private String bankifsc;


}
