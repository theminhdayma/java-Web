package com.data.session09.dao;

import com.data.session09.model.User;

public interface UserDAO {
    User findUserByUsernameAndPassword(String username, String password);
    void addUser(User user);
}
