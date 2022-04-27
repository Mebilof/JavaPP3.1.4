package com.project.PP312.service;

import com.project.PP312.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getListRoles();
    void addRole(Role role);
    Role getRoleByName(Role role);
}
