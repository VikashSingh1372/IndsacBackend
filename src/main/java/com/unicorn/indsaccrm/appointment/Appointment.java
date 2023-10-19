package com.unicorn.indsaccrm.appointment;

import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="appointment")
public class Appointment extends Auditable<String> {
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
    private UUID appointmentInfoId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private int contactnumber;
    @Column
    private String subject;
    @Column
    private String message;
    @Column
    private String status;
    @Column
    private LocalDateTime appointmentDateTime;// Y-M-DTH:M:S (Ex: 2023-10-13T12:30:00)
}
