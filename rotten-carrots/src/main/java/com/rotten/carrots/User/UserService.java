package com.rotten.carrots.User;

import org.springframework.stereotype.Service;


@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserByID(String id) {

        return userRepository.findAll().stream()
                .filter(u -> id.equals(u.getUserID()))
                .findFirst()
                .orElse(null);
    }
}
