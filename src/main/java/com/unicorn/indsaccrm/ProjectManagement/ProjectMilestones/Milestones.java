package com.unicorn.indsaccrm.ProjectManagement.ProjectMilestones;

import com.unicorn.indsaccrm.common.config.Auditable;
import java.time.LocalDate;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projectmilestones")
public class Milestones extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(nullable = false)
    private String milestonesName;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID projectId;

    @Column
    private LocalDate duedate; // "Year-Month-Date"

    @Enumerated(EnumType.STRING)
    @Column
    private MilestonesTableStatus status;

    public enum MilestonesTableStatus{
        NOTSTARTED,
        INPROGRESS,
        COMPLETED,
        ONHOLD,
        CANCELLED
    }

}
