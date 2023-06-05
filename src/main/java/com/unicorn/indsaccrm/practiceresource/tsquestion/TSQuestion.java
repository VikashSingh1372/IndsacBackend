package com.unicorn.indsaccrm.practiceresource.tsquestion;



import com.unicorn.indsaccrm.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tsquestion")
public class TSQuestion  extends Auditable<String> {

    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(nullable=false)
    private UUID userid;
    @Column(nullable=false)
    private UUID testseriesid;
    @Column
    @NotEmpty()
    private String questioncategoryid;
    @Column
    @NotEmpty()
    private String questiontitle;
    @Column
    @NotEmpty()
    private String description;
    @Column
    @NotEmpty()
    private String answer1;
    @Column
    @NotEmpty()
    private  String answer2;
    @Column
    @NotEmpty()
    private String answer3;
    @Column
    @NotEmpty()
    private  String answer4;
    @Column
    @NotEmpty()
    private String answer5;
    @Column
    @NotEmpty()
    private  String answer6;
    @Column
    @NotEmpty()
    private String answer7;
    @Column
    @NotEmpty()
    private  String answer8;
    @Column
    @NotEmpty()
    private String answer9;
    @Column
    @NotEmpty()
    private  String answer10;
    @Column
    @NotEmpty()
    private  String correctanswer;
    @Column
    private  boolean negativescore;
    @Column
    private  boolean negativemarks;
    @Column
    private  boolean positivemarks;

}

