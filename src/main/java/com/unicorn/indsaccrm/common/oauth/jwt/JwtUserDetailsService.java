package com.unicorn.indsaccrm.common.oauth.jwt;


import com.unicorn.indsaccrm.admindefaultvalues.AdminDefaultValues;
import com.unicorn.indsaccrm.admindefaultvalues.AdminDefaultValuesRepository;
import com.unicorn.indsaccrm.common.oauth.group.Groups;
import com.unicorn.indsaccrm.common.referral.Referral;
import com.unicorn.indsaccrm.common.referral.ReferralRepository;
import com.unicorn.indsaccrm.common.oauth.role.Role;
import com.unicorn.indsaccrm.common.oauth.role.RoleRepository;
import com.unicorn.indsaccrm.common.user.RegisterUser;
import com.unicorn.indsaccrm.common.user.User;
import com.unicorn.indsaccrm.common.user.UserRepository;
import com.unicorn.indsaccrm.common.util.email.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
	private ReferralRepository referralCodeRepository;

	@Autowired
	private UserRepository userRepository;

    @Autowired
    private RoleRepository  roleRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private EmailService emailService;

	@Value("${spring.emailutility}")
	private String emailUtility;

	@Autowired
	private AdminDefaultValuesRepository adminDefaultValuesRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.unicorn.indsaccrm.common.user.User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Email " + email + " not found"));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				getAuthorities(user));
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(com.unicorn.indsaccrm.common.user.User user) {
		Collection<GrantedAuthority> grantedAuthorities =new ArrayList<>();
		GrantedAuthority grantedAuthorityId = new SimpleGrantedAuthority("cache-"+user.getId().toString());
		grantedAuthorities.add(grantedAuthorityId);
		for (Role role :user.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
			grantedAuthorities.add(grantedAuthority);
			for (Groups groups :role.getGroups()) {
				GrantedAuthority grantedAuthorityGroup = new SimpleGrantedAuthority(groups.getName());

				grantedAuthorities.add(grantedAuthorityGroup);
			}
		}
		return grantedAuthorities;
	}
	
	public ResponseEntity<?> save(RegisterUser requestUser) {
		// add check for username exists in a DB
		if(userRepository.existsByEmail(requestUser.getEmail())){
			return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
		}

		// create user object
		com.unicorn.indsaccrm.common.user.User newuser = new com.unicorn.indsaccrm.common.user.User();
		newuser.setId(UUID.randomUUID());
		newuser.setName(requestUser.getName());
		newuser.setEmail(requestUser.getEmail());
		newuser.setUsertype(requestUser.getUsertype());
		newuser.setPassword(bcryptEncoder.encode(requestUser.getPassword()));
		newuser.setReferredby(getReferredBy(requestUser));
		List<Role> roles1 = roleRepository.findByNameIn(Arrays.asList("ROLE_USER"));
		newuser.setRoles(roles1);
		User user=userRepository.save(newuser);
		createAdminDefaultValues(user.getId());
		if(emailUtility.contains("true")){
			try {
				emailService.generateOneTimePassword(user);
				logger.info("OTP Sent to Email for verification");
				return new ResponseEntity<>("OTP Sent to Email for verification", HttpStatus.OK);
			}
			catch (Exception e){
				logger.error("Error in Sending OTP to Email for verification, Please check email correctly");
				return new ResponseEntity<>("Error in Sending OTP to Email for verification, Please check email correctly",
						HttpStatus.BAD_REQUEST);
			}
		}
		logger.info("User registered successfully");
		return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
	}

	private void createAdminDefaultValues(UUID userid){
		AdminDefaultValues values=AdminDefaultValues.builder()
				.useradminid(userid)
				.usercid(userid)
				.invoiceduedayperiod(5)
				.taskduedayperiod(5)
				.quotationduedayperiod(5)
				.interactionrecordduedayperiod(5)
				.purchaseorderduedayperiod(5)
				.servicerequestduedayperiod(5).build();
		adminDefaultValuesRepository.save(values);
	}

	private UUID getReferredBy(RegisterUser registerUser){
		if(registerUser.getReferralcode()!=null){
			Referral referral =referralCodeRepository.findByReferralCode(registerUser.getReferralcode());
			if(referral!=null) {
				return referral.getUserid();
		 	}
		}
			return null;
	}
}