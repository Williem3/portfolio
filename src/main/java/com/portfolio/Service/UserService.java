package com.portfolio.Service;

import com.portfolio.entity.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    List<User> findUserList();
}
