package com.unicorn.indsaccrm.common.tickets;

import com.unicorn.indsaccrm.common.config.Auditable;
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
@Table(name = "comments")
public class Comments extends Auditable<String> {
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
    private UUID ticketid;

    @Column
    private String uploadfile;

    @Column()
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID userid;

    @Column(length = 10000)
    @Size(max = 10000)
    private String commenttext;

    @Column
    private long ticketnumber;

}
