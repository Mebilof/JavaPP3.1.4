package project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDao;
import project.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getListUsers(){
        return userDao.getListUsers();
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void addUser(User user){
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User newUser){
        userDao.updateUser(newUser);
    }

    @Transactional
    @Override
    public void deleteUser(long id){
        userDao.deleteUser(id);
    }
}
