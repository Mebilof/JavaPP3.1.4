package com.project.PP312.dao;

import com.project.PP312.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getListRoles();
    void addRole(Role role);
    Role getRoleByName(Role role);
}
