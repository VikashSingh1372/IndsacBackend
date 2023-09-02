package com.unicorn.indsaccrm.common.tickets;

import com.unicorn.indsaccrm.common.config.Auditable;
import com.unicorn.indsaccrm.common.util.enums.Priority;
import com.unicorn.indsaccrm.common.util.enums.TicketStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ticket")
public class Tickets extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column()
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID userid;

    @Column
    private String assigned;

    @Column
    private String uploadfile;

    @Column(length = 3000)
    @Size(max = 3000)
    private  String title;

    @Column(length = 10000)
    @Size(max = 10000)
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Column
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column
    private long ticketnumber;





}
