package com.data.session16.dao;

import com.data.session16.model.User;

public interface AuthDao {
    boolean registerUser(User user);
    boolean login(String username, String password);
    boolean userExists(String username);
    User getUserByUsername(String username);
}
