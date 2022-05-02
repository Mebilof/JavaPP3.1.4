package com.project.PP312.service;

import com.project.PP312.dao.RoleDao;
import com.project.PP312.dao.RoleDaoImpl;
import com.project.PP312.model.Role;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDaoImpl roleDao;

    public RoleServiceImpl(RoleDaoImpl roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    @Transactional(rollbackOn = HibernateException.class)
    public void addRoleToTable(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
