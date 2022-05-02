package com.project.PP312.dao;

import com.project.PP312.model.Role;

import java.util.List;

public interface RoleDao {
    Role getRoleByName(String name);
    void save(Role role);
    List<Role> getAllRoles();
}
