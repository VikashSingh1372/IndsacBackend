package com.unicorn.indsaccrm.common.oauth.googleouth;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="oath2")
public class OautharUserEntity {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private int id;
    @Column(nullable = false)
    @NotEmpty
    private String name;
    @Column(nullable = false)
    @NotEmpty
    private String email;
    @Column(nullable = false)
    @NotEmpty
    private String Password;
    @Enumerated(EnumType.STRING)
    private OutherProvider authanticationProvider;


}
