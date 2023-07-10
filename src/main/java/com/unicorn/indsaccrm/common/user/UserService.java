package com.unicorn.indsaccrm.common.user;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {

    Optional<User> getCurrentUser();

    ResponseEntity<?> resetPassowrd(ResetPasswordResource resetPasswordResource) throws Exception;
}
