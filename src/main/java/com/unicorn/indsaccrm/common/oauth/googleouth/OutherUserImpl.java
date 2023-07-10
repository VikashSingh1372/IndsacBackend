package com.unicorn.indsaccrm.common.oauth.googleouth;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Map;

public class OutherUserImpl implements OautherUserService{
    OautherUserService oautherUserService;
    @Override
    public Map<String, Object> getAttributes() {
        return oautherUserService.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oautherUserService.getAuthorities();
    }
}
