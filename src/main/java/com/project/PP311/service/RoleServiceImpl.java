package com.project.PP311.service;

import com.project.PP311.dao.RoleDao;
import com.project.PP311.model.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role getRoleByName(Role role) {
        return roleDao.getRoleByName(role);
    }
}
