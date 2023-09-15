package com.unicorn.indsaccrm.events;

import com.unicorn.indsaccrm.common.config.Auditable;
import com.unicorn.indsaccrm.common.util.enums.Priority;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Events extends Auditable<String> {
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
    private String readstatus;

    @Column
    private String status;

    @Column
    private String deudate;

    @Column
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column
    private String asignedto;

    @Column
    private UUID customerid;

    @Column
    private String notes;

    @Column
    private String assign;

    @Column
    private String add1;

    @Column
    private String add2;

    @Column
    private String add3;

    @Column
    private String city;

    @Column
    private String pincode;

    @Column
    private String state;

    @Column
    private String country;
}
