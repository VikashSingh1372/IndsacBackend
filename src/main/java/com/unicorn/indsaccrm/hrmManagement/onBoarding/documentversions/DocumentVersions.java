package com.unicorn.indsaccrm.hrmManagement.onBoarding.documentversions;
import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documentversions")
public class DocumentVersions extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID versionid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID documentid;
    @Column
    private Integer versionnumber;
    @Column
    private LocalDate uploaddate;
    @Column
    private String filepath;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID employeeid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;
}
