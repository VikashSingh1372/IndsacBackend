package com.unicorn.indsaccrm.common.sales.enquiry;

import com.unicorn.indsaccrm.common.config.Auditable;
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
@Table(name="ienquiry")
public class Enquiry extends Auditable<String> {
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
    private String name;
    @Column(nullable = false)
    @NotEmpty
    @Email(message = "{errors.invalid_email}")
    private String email;

    @Column(nullable = false)
    @NotEmpty()
    private String phonenumber;
    @Column(nullable = false)
    @NotEmpty
    private String category;

    @Column(nullable = false)
    @NotEmpty
    private String message;

    @Column(nullable = false)
    @NotEmpty
    private String status;
}
