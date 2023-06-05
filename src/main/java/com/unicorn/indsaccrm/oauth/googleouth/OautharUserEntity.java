package com.unicorn.indsaccrm.oauth.googleouth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Builder
@ToString
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
