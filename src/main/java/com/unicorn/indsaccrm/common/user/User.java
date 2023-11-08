package com.unicorn.indsaccrm.common.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unicorn.indsaccrm.common.oauth.role.Role;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
@Entity
@Table(name="users")
public class User {
	private static final long OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes
	@Id
	@GeneratedValue
	@Type(type="org.hibernate.type.UUIDCharType")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	private UUID id;

	@Column(nullable=false)
	@NotEmpty()
	private String name;

	@Column(nullable=false, unique=true)
	@NotEmpty
	@Email(message="{errors.invalid_email}")
	private String email;

	@Column(nullable=false)
	@NotEmpty()
	private String usertype;

	@Column(nullable=false)
	@NotEmpty
	@Size(min=4)
	@JsonIgnore
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinTable(
	      name="user_role",
	      joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
	      inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	private List<Role> roles;

	@Column(name = "oneTimePassword")
	private String oneTimePassword;

	@Column(name = "otpRequestedTime")
	private Date otpRequestedTime;

	@Column(name = "referredby")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID referredby;

	@Column
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID useradminid;

	public boolean isOTPRequired() {
		if (this.getOneTimePassword() == null) {
			return false;
		}

		long currentTimeInMillis = System.currentTimeMillis();
		long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();

		if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
			// OTP expires
			return false;
		}

		return true;
	}

}
