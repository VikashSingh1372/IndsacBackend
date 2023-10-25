package com.unicorn.indsaccrm.common.referral.Reward;

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
    @Table(name="irewards")
    public class Reward extends Auditable<String> {
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
        private String reward_discount_percent;

        @Column
        @Type(type = "org.hibernate.type.UUIDCharType")
        private String reward_amount;

        @Column
        @Type(type = "org.hibernate.type.UUIDCharType")
        private String reward_description;



}
