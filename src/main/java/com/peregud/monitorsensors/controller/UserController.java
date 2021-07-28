package com.peregud.monitorsensors.controller;

import com.peregud.monitorsensors.domain.Users;
import com.peregud.monitorsensors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.peregud.monitorsensors.AppConstants.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(PAGE_USER_SIGN_UP)
    public String signUpNew(@RequestParam(PARAM_USERNAME) String username,
                            @RequestParam(PARAM_PASSWORD) String password,
                            @RequestParam(PARAM_ROLE) String role) {
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(passwordEncoder.encode(password));
        users.setRole(role);
        userService.signUp(users);
        return VIEW_SUCCESS;
    }
}
