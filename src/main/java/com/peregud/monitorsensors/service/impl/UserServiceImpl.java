package com.peregud.monitorsensors.service.impl;

import com.peregud.monitorsensors.domain.Users;
import com.peregud.monitorsensors.repository.UserRepository;
import com.peregud.monitorsensors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void signUp(Users users) {
        userRepository.save(users);
    }
}
