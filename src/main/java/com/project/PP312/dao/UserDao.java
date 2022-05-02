package com.project.PP312.dao;

import com.project.PP312.model.User;

import java.util.List;


public interface UserDao {
    User getUserByUsername(String username);
    User getUserById(long id);
    Iterable<User> getAllUsers();
    void save(User user);
    void update(User user);
    void deleteById(long id);
}
