package com.unicorn.indsaccrm.interactionrecord;

import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "interactionrecord")
public class InteractionRecord extends Auditable<String> {
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
    private String direction;

    @Column
    private String status;

    @Column
    private String priority;

    @Column
    private String enquiry;

    @Column
    private String lead;

    @Column
    private String product;

    @Column
    private String owner;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID customerid;

}
