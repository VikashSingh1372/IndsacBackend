package com.unicorn.indsaccrm.ProjectManagement.ProjectTimeTracing;

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
@Table(name = "projecttimetracing")
public class TimeTracing extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUDi",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID timeTracingId;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID tasksId;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID userId;

    @Column
    private String date;

    @Column(nullable = false)
    private Double hoursWorked;

    @Column
    private String description;
}

