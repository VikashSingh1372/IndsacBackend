package com.unicorn.indsaccrm.hrmManagement.recruitmentManagementSystem.hiringteam;
import com.unicorn.indsaccrm.common.config.Auditable;
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
@Table(name = "hiringteam")
public class HiringTeam extends Auditable<String> {
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
    private UUID departmentid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID jobid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;
}
