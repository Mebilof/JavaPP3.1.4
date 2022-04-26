package com.project.PP312.util;

import com.project.PP312.model.Role;
import com.project.PP312.model.User;
import com.project.PP312.service.RoleService;
import com.project.PP312.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;
    private final RoleService roleService;

    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init(){
        Role role = new Role("ROLE_ADMIN");
        roleService.addRole(role);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        userService.addUser(new User("1", "White Sebring", "2004", "1", roles));
    }
}
