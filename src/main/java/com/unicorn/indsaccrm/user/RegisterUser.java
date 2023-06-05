package com.unicorn.indsaccrm.user;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 *
 *public class User extends Auditable<String>
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUser
{
	@NotEmpty()
	private String name;

	@NotEmpty
	@Email(message="{errors.invalid_email}")
	private String email;

	@NotEmpty()
	private String usertype;

	@NotEmpty
	@Size(min=4)
	private String password;

}
