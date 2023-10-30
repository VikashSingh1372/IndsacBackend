package com.unicorn.indsaccrm.hrmManagement.employee.Departments;

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
@Table(name = "departments")
public class Departments extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column
    private String departmentname;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID useradminid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID usercid;
}
