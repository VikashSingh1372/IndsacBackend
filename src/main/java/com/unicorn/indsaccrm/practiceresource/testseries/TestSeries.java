package com.unicorn.indsaccrm.practiceresource.testseries;
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
@Table(name = "testseries")
public class TestSeries  extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
//    @Column(nullable=false)
//    private UUID userid;
    @Column(nullable = false)
    @NotEmpty
    private String userid;

    @Column
    @NotEmpty
    private  String name;
    @Column
    @NotEmpty
    private String description;
    @Column
    @NotEmpty
    private  String testseriescategoryid;



}
