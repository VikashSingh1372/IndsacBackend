package com.unicorn.indsaccrm.ProjectManagement.ProjectTasks;

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
@Table(name = "projecttasks")
public class ProjectTasks extends Auditable<String> {


    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(nullable = false)
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
    @Column
    private TasksStatus status;

    public enum TasksStatus {
        NOTSTARTED,
        INPROGRESS,
        COMPLETED,
        ONHOLD,
        CANCELLED
    }
}
