package com.data.session16.service;

import com.data.session16.dao.AuthDao;
import com.data.session16.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {
    @Autowired
    private AuthDao authDao;

    @Override
    public boolean registerUser(User user) {
        return authDao.registerUser(user);
    }

    @Override
    public boolean login(String username, String password) {
        return authDao.login(username, password);
    }

    @Override
    public boolean userExists(String username) {
        return authDao.userExists(username);
    }

    @Override
    public User getUserByUsername(String username) {
        return authDao.getUserByUsername(username);
    }
}
