package com.unicorn.indsaccrm.loginlocation;
import com.unicorn.indsaccrm.common.config.Auditable;
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
@Table(name = "loginlocation")
public class loginlocation extends Auditable<String> {
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
    private UUID userid;
    @Column
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID useradminid;
    @Column
    private String countryCode;
    @Column
    private String regionCode;
    @Column
    private String regionName;
    @Column
    private String city;
    @Column
    private String countryName;
    @Column
    private String Regiontimezoneid;
    @Column
    private String regiontzcurrenttime;
    @Column
    private String regiontzcode;
    @Column
    private String regiontzname;
    @Column
    private String regionutcoffset;
}
