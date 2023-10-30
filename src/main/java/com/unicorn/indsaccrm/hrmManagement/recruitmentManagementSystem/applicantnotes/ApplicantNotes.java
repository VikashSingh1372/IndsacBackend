package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.applicantnotes;
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
@Table(name = "applicantnotes")
public class ApplicantNotes extends Auditable<String> {
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
    private UUID applicationid;
    @Column
    private String content;
    @Column
    private LocalDate notedate;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;
}
