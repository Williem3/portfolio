package com.portfolio.dao;

import com.portfolio.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);

    List<User> findAll();

}
