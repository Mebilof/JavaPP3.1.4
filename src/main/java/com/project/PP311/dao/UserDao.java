package com.project.PP311.dao;

import com.project.PP311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface UserDao extends JpaRepository<User, Long> {
//    List<User> getListUsers();
//    User getUser(long id);
//    void addUser(User user);
//    void updateUser(User newUser);
//    void deleteUser(long id);
}
