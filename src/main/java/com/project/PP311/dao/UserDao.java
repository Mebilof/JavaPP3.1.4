package com.project.PP311.dao;

import com.project.PP311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {
    List<User> getListUsers();
    User getUserById(long id);
    User getUserByName(String email);
    void addUser(User user);
    void updateUser(User newUser);
    void deleteUser(long id);
}
