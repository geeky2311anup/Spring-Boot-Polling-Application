package com.anup.pollingApp.springBootPollingApplication.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Anup Kumar Singh - 2025
 */

public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
