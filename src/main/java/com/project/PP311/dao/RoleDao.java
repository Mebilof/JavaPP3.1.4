package com.project.PP311.dao;

import com.project.PP311.model.Role;

public interface RoleDao {
    void addRole(Role role);
    Role getRoleByName(Role role);
}
