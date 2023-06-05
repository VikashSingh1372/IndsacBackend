package com.unicorn.indsaccrm.practiceresource.category;

import com.unicorn.indsaccrm.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questionseriescategory")
public class QuestionSeriesCategory extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(nullable=false)
    private UUID userid;
//    @Column(nullable = false)
//    @NotEmpty
//    private int userid;
    @Column
    @NotEmpty
    private String name;
    @Column
    @NotEmpty
    private String lowleveldescription;
    @Column
    @NotEmpty
    private String highleveldescription;
    @Column
    @NotEmpty
    private String testduration;
    @Column
    @NotEmpty
    private String scheduledtime;

}
