package com.project.PP311.dao;

import com.project.PP311.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getListUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
    @Override
    public User getUserById(long id) {
        return entityManager.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public User getUserByName(String firstname) {
        return entityManager.createQuery("select u from User u where u.owner = :firstname", User.class)
                .setParameter("firstname", firstname).getSingleResult();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void updateUser(User newUser) {
        entityManager.merge(newUser);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }
}
