package com.unicorn.indsaccrm.role;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

}
