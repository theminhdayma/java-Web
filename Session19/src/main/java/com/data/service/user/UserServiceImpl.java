package com.data.service.user;

import com.data.entity.User;
import com.data.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userRepo;

    @Override
    public List<User> findAll(){
        return userRepo.findAll();
    }

    @Override
    public List<User> findAll(int page, int size){
        return userRepo.findAll(page, size);
    }

    @Override
    public void changeStatus(Long id, boolean status){
        userRepo.changeStatus(id, status);
    }

    @Override
    public long count(){
        return userRepo.count();
    }
}
