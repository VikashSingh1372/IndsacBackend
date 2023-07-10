package com.unicorn.indsaccrm.common.user.usereducation;

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
@Table(name="usereducation")
public class UserEducation {

    @Id
    @GeneratedValue()
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID userid;

    @Column(nullable=false)

    private String education;

    @Column(nullable=false)

    private String universityName;

    @Column(nullable=false)

    private String universityLocation;
}
