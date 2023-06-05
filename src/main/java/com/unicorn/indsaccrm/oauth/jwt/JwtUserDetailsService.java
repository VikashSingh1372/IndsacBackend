package com.unicorn.indsaccrm.oauth.jwt;


import com.unicorn.indsaccrm.role.Role;
import com.unicorn.indsaccrm.role.RoleRepository;
import com.unicorn.indsaccrm.user.RegisterUser;
import com.unicorn.indsaccrm.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);

	@Autowired
	private UserRepository userRepository;

    @Autowired
    private RoleRepository  roleRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.unicorn.indsaccrm.user.User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Email " + email + " not found"));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				getAuthorities(user));
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(com.unicorn.indsaccrm.user.User user) {
		String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}
	
	public ResponseEntity<?> save(RegisterUser requestUser) {
		// add check for username exists in a DB
		if(userRepository.existsByEmail(requestUser.getEmail())){
			return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
		}
		// create user object
		com.unicorn.indsaccrm.user.User newuser = new com.unicorn.indsaccrm.user.User();
		newuser.setId(UUID.randomUUID());
		newuser.setName(requestUser.getName());
		newuser.setEmail(requestUser.getEmail());
		newuser.setUsertype(requestUser.getUsertype());
		newuser.setPassword(bcryptEncoder.encode(requestUser.getPassword()));

		Role roles1 = roleRepository.findByName("ROLE_USER").get();
		newuser.setRoles(List.of(roles1));

		userRepository.save(newuser);
		logger.info("User registered successfully");
		return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
	}
}