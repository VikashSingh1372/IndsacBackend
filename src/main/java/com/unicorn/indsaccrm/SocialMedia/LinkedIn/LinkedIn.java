package com.unicorn.indsaccrm.SocialMedia.LinkedIn;

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
@Table(name = "Linkedin")
public class LinkedIn extends Auditable<String> {

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
    private UUID userid;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID orgid;

    @Column
    private String twitterApiKey;

    @Column
    private String twitterApiKeyValue;

    @Column
    private String twitterConsumerAppKeyVariable;

    @Column
    private String twitterConsumerAppKeyValue;

    @Column
    private String twitterConsumerAppSecretVariable;

    @Column
    private String twitterConsumerAppSecretValue;

    @Column
    private String twitterBearerTokenVariable;

    @Column
    private String twitterBearerTokenValue;

    @Column
    private String twitterAccessTokenVariable;

    @Column
    private String twitterAccessTokenValue;

    @Column
    private String twitterTokenSecretVariable;

    @Column
    private String twitterTokenSecretValue;

}
