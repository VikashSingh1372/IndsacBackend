package com.unicorn.indsaccrm.clientticket;

import com.unicorn.indsaccrm.config.Auditable;
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
    private String readstatus;

    @Column
    private String subject;

    @Column
    private String duedate;

    @Column
    private String priority;

    @Column
    private String status;

    @Column
    private String asignedto;

    @Column
    private String useradminid;

    @Column
    private String usercid;
    @Column
    private String customerid;

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
