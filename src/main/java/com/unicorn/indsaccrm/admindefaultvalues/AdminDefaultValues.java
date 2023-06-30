package com.unicorn.indsaccrm.admindefaultvalues;

import com.unicorn.indsaccrm.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

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

    @Column(nullable=false, unique = true)
    private String useradminid;

    @Column
    private String usercid;

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

    @Column(nullable=false)
    private String esi_email;

    @Column(nullable=false)
    private String esi_address1;

    @Column
    private String esi_address2;

    @Column
    private String esi_address3;

    @Column(nullable=false)
    private String esi_city;

    @Column(nullable=false)
    private String esi_pincode;

    @Column(nullable=false)
    private String esi_state;

    @Column(nullable=false)
    private String esi_country;

    @Column(nullable=false)
    private String etc_line1;

    @Column(nullable=false)
    private String etc_line2;

    @Column(nullable=false)
    private String etc_line3;

    @Column(nullable=false)
    private String etc_line4;

    @Column(nullable=false)
    private String n_heading;

    @Column(nullable=false)
    private String n_line1;

    @Column(nullable=false)
    private String n_line2;

    @Column(nullable=false)
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
