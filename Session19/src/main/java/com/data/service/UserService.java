package com.data.service;

import com.data.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void addUser(User user);

    void delete(int id);
}
