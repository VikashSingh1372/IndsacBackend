package com.unicorn.indsaccrm.hrmManagement.onBoarding.documentaccess;
import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documentaccess")
public class DocumentAccess extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID accessid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID employeeid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID documentid;
    private enum AccessLevel{
        read_Only,write_Only
    }
    @Column
    private AccessLevel accesslevel;
    @Column
    private LocalDate accessdate;

    /*@Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID employeeid;
   */
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID usercid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;
}
