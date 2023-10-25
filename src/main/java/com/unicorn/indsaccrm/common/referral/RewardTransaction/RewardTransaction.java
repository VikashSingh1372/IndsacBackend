package com.unicorn.indsaccrm.common.referral.RewardTransaction;

import com.unicorn.indsaccrm.common.config.Auditable;
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
@Table(name="irewardtransactions")
public class RewardTransaction extends Auditable<String> {
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
    private UUID transaction_id;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID user_reward_id;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID transaction_type;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    String description;


}
