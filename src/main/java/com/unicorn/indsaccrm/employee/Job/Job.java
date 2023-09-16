package com.unicorn.indsaccrm.employee.Job;

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
@Table(name = "job")
public class Job extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column
    private String jobtitle;
    @Column
    private Double minsalary;
    @Column
    private Double maxsalary;
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID useradminid;
}
