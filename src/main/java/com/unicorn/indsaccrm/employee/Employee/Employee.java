package com.unicorn.indsaccrm.employee.Employee;

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
@Table(name = "employee")
public class Employee extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String email;
    @Column
    private String phonenumber;
    @Column
    private String hiredate;
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID jobid;
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID managerid;
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID departmentid;
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID useradminid;
}
