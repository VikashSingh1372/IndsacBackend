package com.unicorn.indsaccrm.clientticket;

import com.unicorn.indsaccrm.common.config.Auditable;
import com.unicorn.indsaccrm.common.util.enums.Priority;
import java.time.LocalDate;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="clientticket")
public class ClientTicket extends Auditable<String> {

    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;

    @Column
    private String readstatus;

    @Column
    private String subject;

    @Column
    private LocalDate duedate; // "Year-Month-Date"

    @Column
    @Enumerated(EnumType.STRING)
    private Priority priority;


    @Column
    private String status;

    @Column
    private String asignedto;

    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID customerid;

    @Column
    private String notes;

    @Column
    private String type;

    @Column
    private String resolution;

    @Column
    private String remark;

    @Column
    private String assign;
    @Column
    private String clientreadstatus;

    @Column
    private String adminreadstatus;

    @Column
    private String state;

    @Column
    private String country;

}
