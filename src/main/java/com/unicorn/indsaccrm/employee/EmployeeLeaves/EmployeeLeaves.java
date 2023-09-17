package com.unicorn.indsaccrm.employee.EmployeeLeaves;

import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employeeleaves")
public class EmployeeLeaves extends Auditable<String> {
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
    @NotNull
    private LocalDate leavestartdate;
    @Column
    @Enumerated(EnumType.STRING)
    private Leavetype leavetype;
    private enum Leavetype{
        Vacation,SickLeave,MaternityOrPaternity,Unpaid,Other
    }
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
    private enum Status{
        Pending,Approved,Rejected
    }
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID useradminid;
}
