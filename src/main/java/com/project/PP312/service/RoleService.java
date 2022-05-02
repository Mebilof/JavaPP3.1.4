package com.project.PP312.service;

import com.project.PP312.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleByName(String name);
    void addRoleToTable(Role role);
    List<Role> getAllRoles();
}
