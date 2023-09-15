package com.unicorn.indsaccrm.task;

import com.unicorn.indsaccrm.common.config.Auditable;
import com.unicorn.indsaccrm.common.util.enums.Priority;
import java.time.LocalDate;
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
@Table(name = "task")
public class Task extends Auditable<String> {
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
    private UUID useradminid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID usercid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID customerid;

    @Column
    private String readstatus;

    @Column
    private String subject;

    @Column
    private LocalDate duedate; // "Year-Month-Date" "yyyy-mm-dd"

    @Column
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column
    private String notes;

    @Column
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID asignedto;

    @Column
    private String assign;

    public enum TaskStatus{
        Open,InProgress,Pending,Completed,Canceled,Deferred,WaitingforCustomer,WaitingforInternalReview,
        Reassigned,OnHold,Overdue,Scheduled,NeedsMoreInformation,Escalated,Closed,NotApplicable
    }

}
