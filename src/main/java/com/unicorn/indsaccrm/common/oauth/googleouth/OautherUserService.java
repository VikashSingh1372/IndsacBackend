package com.unicorn.indsaccrm.common.oauth.googleouth;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Map;

public interface OautherUserService {
    Map<String, Object> getAttributes();
    Collection<? extends GrantedAuthority> getAuthorities();


}
