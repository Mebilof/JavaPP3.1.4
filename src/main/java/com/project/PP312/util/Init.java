package com.project.PP312.util;

import com.project.PP312.model.Role;
import com.project.PP312.model.User;
import com.project.PP312.service.RoleService;
import com.project.PP312.service.RoleServiceImpl;
import com.project.PP312.service.UserService;
import com.project.PP312.service.UserServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    public Init(UserServiceImpl userService,
                     RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createRoot() {
        Role userRole = new Role("ROLE_USER");
        roleService.addRoleToTable(userRole);

        Role adminRole = new Role("ROLE_ADMIN");
        roleService.addRoleToTable(adminRole);

        User root = new User("1", "1",  "ROLE_USER ROLE_ADMIN");
        userService.save(root);

        User user = new User("2", "2", "2");
        userService.save(user);
    }
}
