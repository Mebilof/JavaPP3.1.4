package com.project.PP311.service;

import com.project.PP311.model.Role;

public interface RoleService {
    void addRole(Role role);
    Role getRoleByName(Role role);
}
