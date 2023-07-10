package com.unicorn.indsaccrm.common.user;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResetPasswordResource {
    @NotEmpty()
    private String oldpassword;

    @NotEmpty()
    private String newpassword;
}
