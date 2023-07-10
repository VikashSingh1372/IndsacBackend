package com.unicorn.indsaccrm.common.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Override
    public Optional<User> getCurrentUser() {
        return userRepository.findByEmail(((org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal()).getUsername());
    }

    @Override
    public ResponseEntity<?> resetPassowrd(ResetPasswordResource resetPasswordResource) throws Exception {
        Optional<com.unicorn.indsaccrm.common.user.User> user=userRepository.findByEmail(((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getUsername());
        authenticate(user.get().getEmail(),resetPasswordResource.getOldpassword());
        user.get().setPassword(bcryptEncoder.encode(resetPasswordResource.getNewpassword()));
        userRepository.save(user.get());
        logger.info("password reset successfully");
        return new ResponseEntity<>("registered successfully", HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
