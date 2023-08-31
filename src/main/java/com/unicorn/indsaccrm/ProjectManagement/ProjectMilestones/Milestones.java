package com.unicorn.indsaccrm.ProjectManagement.ProjectMilestones;

import com.unicorn.indsaccrm.common.config.Auditable;
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
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUDi",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID milestonesId;

    @Column(nullable = false)
    @Max(value = 100)
    private String milestonesName;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID projectId;

    @Column()
    private String dueDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MilestonesTableStatus status;

    public enum MilestonesTableStatus{
        NOTSTARTED,
        INPROGRESS,
        COMPLETED,
        ONHOLD,
        CANCELLED
    }

}
