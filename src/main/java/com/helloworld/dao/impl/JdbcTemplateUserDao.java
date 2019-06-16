package com.helloworld.dao.impl;

import com.helloworld.dao.UserDao;
import com.helloworld.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcTemplateUserDao implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users",
                new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User getOne(String email) {
        return jdbcTemplate.query(
                "SELECT * FROM users WHERE email = ?",
                new Object[]{email},
                new BeanPropertyRowMapper<>(User.class)
        ).stream().findAny().orElse(null);
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update("INSERT INTO users VALUES (?, ?, ?)",
                user.getName(), user.getSurname(), user.getEmail());
    }
}
