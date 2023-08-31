package com.unicorn.indsaccrm.ProjectManagement.ProjectTasks;

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
@Table(name = "projecttasks")
public class Tasks extends Auditable<String> {


    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUDi",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID taskId;

    @Column(nullable = false)
    @Max(value = 100)
    private String taskName;

    @Column
    private String description;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID projectId;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID userId;

    @Column
    private String date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TasksStatus status;

    public enum TasksStatus {
        NOTSTARTED,
        INPROGRESS,
        COMPLETED,
        ONHOLD,
        CANCELLED
    }
}
