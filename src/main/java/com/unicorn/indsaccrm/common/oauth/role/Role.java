package com.unicorn.indsaccrm.common.oauth.role;

import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import com.unicorn.indsaccrm.common.oauth.group.Groups;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Ramesh Fadatare
 *
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="roles")
public class Role
{
	@Id
	@GeneratedValue
	@Type(type="org.hibernate.type.UUIDCharType")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	private UUID id;
	@Column(nullable=false, unique=true)
	@NotEmpty
	private String name;

	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinTable(
			name="role_group",
			joinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="GROUP_ID", referencedColumnName="ID")})
	private List<Groups> groups;
}
