package com.unicorn.indsaccrm.company;

import com.unicorn.indsaccrm.common.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company extends Auditable<String> {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUDi",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID owneruserid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID usercid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID useradminid;

    @Column
    @NotNull
    @Size(max = 100)
    private String company_name;

    @Column
    @Size(max = 255)
    private String address;

    @Column
    private String state;

    @Column
    private String country;

    @Column
    @Size(max = 20)
    private String phone_number;

    @Column
    @Size(max = 100)
    private String email;

    @Column
    @Enumerated
    private Currencies currencies;

    private enum Currencies{
        INR
    }

    @Enumerated
    @Column
    private TimeZone timezone;

    private enum TimeZone{
        INDIA
    }

    @Column(name="active")
    private boolean active = true;

    @Column
    private String company_logo;

    @Column
    private String Business_Hours;
}
