package com.data.repository;

import com.data.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    void addUser(User user);

    void delete(int id);
}
