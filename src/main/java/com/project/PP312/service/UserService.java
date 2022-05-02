package com.project.PP312.service;

import com.project.PP312.model.User;

import java.util.List;

public interface UserService {
    User getUserByUsername(String username);
    Iterable<User> getAllUsers();
    void save(User user);
    void update(User user);
    void deleteById(long id);
    User getUserById(long id);
}
