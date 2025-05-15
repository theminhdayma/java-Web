package com.data.session06.dao.Bai2;

import com.data.session06.model.Bai2.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    boolean save(User user);

    boolean login(String username, String password);
}
