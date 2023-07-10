package com.unicorn.indsaccrm.common.config;


import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AuditorAwareImpl implements AuditorAware<String> {
@Override
public Optional<String> getCurrentAuditor() {
    Collection<GrantedAuthority> authorities= ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                    .getAuthorities();
    List<GrantedAuthority> filteredAuthorities = authorities.stream()
            .filter(authority -> authority.getAuthority().startsWith("cache-"))
            .collect(Collectors.toList());
    return Optional.of(filteredAuthorities.get(0).getAuthority().toString().replaceAll("cache-",""));
        }
}
