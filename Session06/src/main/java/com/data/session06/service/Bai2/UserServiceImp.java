package com.data.session06.service.Bai2;

import com.data.session06.dao.Bai2.UserDao;
import com.data.session06.dao.Bai2.UserDaoImp;
import com.data.session06.model.Bai2.User;

import java.util.List;

public class UserServiceImp implements UserService{
    private final UserDao userDao;

    public UserServiceImp() {
        userDao = new UserDaoImp();
    }
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean save(User user) {
        return userDao.save(user);
    }

    @Override
    public boolean login(String username, String password) {
        return userDao.login(username, password);
    }
}
