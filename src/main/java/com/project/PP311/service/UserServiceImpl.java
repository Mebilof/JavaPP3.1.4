package com.project.PP311.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.PP311.dao.UserDao;
import com.project.PP311.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getListUsers(){
        return userDao.findAll();
    }

    @Override
    public User getUser(long id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public void addUser(User user){
        userDao.save(user);
    }

    @Transactional
    @Override
    public void updateUser(User newUser){
        userDao.save(newUser);
    }

    @Transactional
    @Override
    public void deleteUser(long id){ userDao.delete(getUser(id)); }
}
