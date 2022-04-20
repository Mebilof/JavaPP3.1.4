package project.dao;

import project.model.User;

import java.util.List;

public interface UserDao {
    List<User> getListUsers();
    User getUser(long id);
    void addUser(User user);
    void updateUser(User newUser);
    void deleteUser(long id);
}
