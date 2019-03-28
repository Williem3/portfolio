package com.portfolio.Service.Impl;

import com.portfolio.Service.UserService;
import com.portfolio.dao.UserDao;
import com.portfolio.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
    public List<User> findUserList() {
        return userDao.findAll();
    }
}
