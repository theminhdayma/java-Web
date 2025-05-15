package com.data.session09.service;

import com.data.session09.model.User;

public interface UserService {
    User login(String username, String password);
    void register(User user);
}

