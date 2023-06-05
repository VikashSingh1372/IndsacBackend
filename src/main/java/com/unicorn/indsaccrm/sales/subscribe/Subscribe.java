package com.unicorn.indsaccrm.sales.subscribe;

import com.unicorn.indsaccrm.config.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="subscribe")
public class Subscribe extends Auditable<String> {

    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(nullable = false)
    @NotEmpty()
    private String status;
    @Column(nullable = false)
    @NotEmpty
    @Email(message = "{errors.invalid_email}")
    private String email;

}
