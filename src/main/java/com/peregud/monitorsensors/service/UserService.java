package com.peregud.monitorsensors.service;

import com.peregud.monitorsensors.domain.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void signUp(Users users);
}
