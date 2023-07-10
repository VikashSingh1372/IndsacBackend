package com.unicorn.indsaccrm.common.user;

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
@Table(name="userprofile")
public class UserProfile {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(nullable=false)

    @NotEmpty()
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID userid;

    @Column(nullable=false, unique=true)
    @NotEmpty
    private String skill;

    @Column(nullable=false)
    @NotEmpty()
    private String education;

}
