package com.anup.pollingApp.springBootPollingApplication;

import com.anup.pollingApp.springBootPollingApplication.model.User;

/**
 * Created by Anup Kumar Singh - 2025
 */

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private User user;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        this.user = user;
    }

    public int getId() {
        return user.getId();
    }

    public void update(User newTo) {
        user = newTo;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return user.toString();
    }
}