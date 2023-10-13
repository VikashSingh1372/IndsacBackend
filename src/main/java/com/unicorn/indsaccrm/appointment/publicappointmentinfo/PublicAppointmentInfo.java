package com.unicorn.indsaccrm.appointment.publicappointmentinfo;

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
@Table(name="publicappointmentinfo")
public class PublicAppointmentInfo extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column
    private String businessName;
    @Column
    private String businessAddress;
    @Column
    private String businessLogofile;
    @Column
    private int businessContactNumber;
    @Column
    private String businessEmailAddress;
    @Column
    private String businessWebsite;
    @Column
    private String businessOtherInfo;
    @Column
    private String publicLink;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;
    @Column
    private String publicstatus;
}
