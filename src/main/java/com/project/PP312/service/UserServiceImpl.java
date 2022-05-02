package com.project.PP312.service;

import com.project.PP312.dao.UserDaoImpl;
import com.project.PP312.model.Role;
import org.hibernate.HibernateException;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.PP312.dao.UserDao;
import com.project.PP312.model.User;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDaoImpl userDao;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Lazy
    public UserServiceImpl(UserDaoImpl userDao,
                           RoleService roleService,
                           PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            System.out.println("User '" + username + "' not found");
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @javax.transaction.Transactional(rollbackOn = HibernateException.class)
    public void save(User user) {
        Set<Role> roles = new HashSet<>();
        String[] rolesList = user.getRolesList().split(" ");
        for (String role : rolesList) {
            roles.add(roleService.getRoleByName(role));
        }
        user.setRoles(roles);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userDao.save(user);
    }

    @Override
    @javax.transaction.Transactional(rollbackOn = HibernateException.class)
    public void update(User user) {

        if (user.getUsername().length() < 1) {
            return;
        }

        Set<Role> roles = new HashSet<>();
        String[] rolesList = user.getRolesList().split(" ");
        for (String role : rolesList) {
            roles.add(roleService.getRoleByName(role));
        }
        user.setRoles(roles);

        if (user.getPassword().equals("")) {
            user.setPassword(getUserById(user.getId()).getPassword());
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        userDao.update(user);
    }

    @Override
    @Transactional(rollbackOn = HibernateException.class)
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
}
