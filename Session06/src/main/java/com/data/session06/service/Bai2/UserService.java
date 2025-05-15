package com.data.session06.service.Bai2;

import com.data.session06.model.Bai2.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    boolean save(User user);

    boolean login(String username, String password);
}
