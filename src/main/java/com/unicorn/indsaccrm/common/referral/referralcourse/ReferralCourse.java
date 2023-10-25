package com.unicorn.indsaccrm.common.referral.referralcourse;


import com.unicorn.indsaccrm.common.config.Auditable;
import com.unicorn.indsaccrm.common.util.enums.ReferralStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="ireferralcourse")
public class ReferralCourse extends Auditable<String> {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID userid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID referralID;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID invitedUserID;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID courseid;

    @Column
    private String invitedUserSkills;

    @Column
    private String courseRequiredSkills;

    @Column
    private ReferralStatus status;
    
}

