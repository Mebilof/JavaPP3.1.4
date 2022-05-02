package com.project.PP312.dao;

import com.project.PP312.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager em;

    public RoleDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Role getRoleByName(String name) {
        return em.createQuery("select r from Role r", Role.class)
                .getResultStream()
                .filter(role -> role.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public void save(Role role) {
        em.persist(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return em.createQuery("select r from Role r", Role.class)
                .getResultList();
    }
}
