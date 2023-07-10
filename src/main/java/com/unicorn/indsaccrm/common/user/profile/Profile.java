package com.unicorn.indsaccrm.common.user.profile;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="profile")
public class Profile {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUDi",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID userid;

    @Column
    private String skill;

    @Column
    private String state;

    @Column
    private String country;

    @Column
    private String notes;

}

