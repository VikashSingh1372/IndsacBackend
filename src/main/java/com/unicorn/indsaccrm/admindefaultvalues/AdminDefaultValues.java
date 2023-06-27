package com.unicorn.indsaccrm.admindefaultvalues;

import com.unicorn.indsaccrm.config.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.UUID;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Column(nullable=false)
    @NotEmpty(message="{errors.usercid_required}")
    private String usercid;

    @Column(nullable=false)
    @NotEmpty(message="{errors.invoiceformat_required}")
    private String invoiceformat;

    @Column(nullable=false)
    @NotEmpty(message="{errors.invoicelogofile_required}")
    private String invoicelogofile;

    @Column(nullable=false)
    @NotEmpty(message="{errors.businesslogofile_required}")
    private String businesslogofile;

    @Column(nullable=false)
    @NotEmpty(message="{errors.currency_required}")
    private String currency;

    @Column(nullable=false)
    @NotEmpty(message="{errors.servicecharge_required}")
    private String servicecharge;

    @Column
    private String discount;
    @Column(nullable=false)
    @NotEmpty(message="{errors.frieghtcharge_required}")
    private String frieghtcharge;

    @Column(nullable=false)
    private String esi_sellername;

    @Column(nullable=false)
    private String esi_contactfirstname;

    @Column(nullable=false)
    @NotEmpty(message="{errors.esi_contactlastname_required}")
    private String esi_contactlastname;

    @Column(nullable=false)
    @NotEmpty(message="{errors.subcategory_required}")
    private String subcategory;

    @Column
    private String esi_gst;

    @Column(nullable=false)
    private String esi_website;

    @Column(nullable=false, unique = true)
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

    @Column(nullable=false)
    private String n_line4;

    @Column(nullable=false)
    private String gst;

    @Column(nullable=false)
    private String notes;

    @Column(nullable=false)
    private String default123;

    @Column(nullable=false)
    private String bankname;

    @Column(nullable=false)
    private String bankacno;

    @Column(nullable=false)
    private String bankadd;

    @Column(nullable=false)
    private String bankifsc;


}
