package com.helloworld.dao;

import com.helloworld.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> getAll();

    User getOne(String email);

    void add(User user);

}
