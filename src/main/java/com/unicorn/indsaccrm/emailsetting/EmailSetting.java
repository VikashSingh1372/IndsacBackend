package com.unicorn.indsaccrm.emailsetting;

import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emailsetting")
public class EmailSetting extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID useradminid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID usercid;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String outgoingserver;

    @Column
    private String port;

    @Column
    private String agreetermconditions;

    @Column
    private String status;



}
