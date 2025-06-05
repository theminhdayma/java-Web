package com.data.dao.user;

import com.data.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    List<User> findAll(int page, int size);
    void changeStatus(Long id, boolean status);
    long count();
}
