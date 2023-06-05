package com.unicorn.indsaccrm.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


/**
 * @author Ramesh Fadatare
 *
 */
public interface UserRepository extends CrudRepository<User, UUID>,JpaRepository<User, UUID>
{

	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);


}
