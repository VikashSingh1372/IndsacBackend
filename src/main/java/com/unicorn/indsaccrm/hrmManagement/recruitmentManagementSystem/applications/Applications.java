package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applications;
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
@Table(name = "applications")
public class Applications extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID applicationid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID jobid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID applicantid;
    @Column
    private Status status;
    private enum Status{
        applied, under_review, rejected, hired
    }
    @Column
    private LocalDate applicationdate;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;
}
