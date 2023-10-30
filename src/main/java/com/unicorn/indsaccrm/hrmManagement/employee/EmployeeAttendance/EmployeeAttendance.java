package com.unicorn.indsaccrm.hrmManagement.employee.EmployeeAttendance;

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
@Table(name = "employeeattendance")
public class EmployeeAttendance extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID employeeid;
    @Column
    private String attendancedate;
    @Column
    private String clockinTemporal;
    @Column
    private String clockoutTemporal;
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID useradminid;
}
