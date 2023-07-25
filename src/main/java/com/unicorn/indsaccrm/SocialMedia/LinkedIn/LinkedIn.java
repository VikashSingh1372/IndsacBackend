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
    private String LinkedInApiKey;

    @Column
    private String LinkedInApiKeyValue;

    @Column
    private String linkedInConsumerAppKeyVariable;

    @Column
    private String linkedInConsumerAppKeyValue;

    @Column
    private String linkedInConsumerAppSecretVariable;

    @Column
    private String linkedInConsumerAppSecretValue;

    @Column
    private String linkedInBearerTokenVariable;

    @Column
    private String linkedInBearerTokenValue;

    @Column
    private String linkedInAccessTokenVariable;

    @Column
    private String linkedInAccessTokenValue;

    @Column
    private String linkedInTokenSecretVariable;

    @Column
    private String linkedInTokenSecretValue;

}
