package com.unicorn.indsaccrm.practiceresource.answer;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tsanswer")
public class TSAnswer  extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUDi",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(nullable=false)
    private UUID userid;
     @Column(nullable=false)
     private UUID tsquestionid;
    @Column(nullable = false)
    @NotEmpty
    private  String answer;
    @Column
    @NotEmpty
    private String screenstarttime;
    @Column
    @NotEmpty
    private String screenendtime;
    @Column
    @NotEmpty
    private String finalsubmission;
    @Column
    @NotEmpty
    private  String marksobtained;

}
