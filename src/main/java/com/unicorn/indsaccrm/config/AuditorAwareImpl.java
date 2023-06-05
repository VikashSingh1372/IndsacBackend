package com.unicorn.indsaccrm.config;


import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
@Override
public Optional<String> getCurrentAuditor() {
    //return Optional.of("CustomUser");
        //Can use Spring Security to return currently logged in user
    return Optional.ofNullable(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        }
}
