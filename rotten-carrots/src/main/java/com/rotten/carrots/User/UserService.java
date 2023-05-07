package com.rotten.carrots.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    UserRepository userRepository;

    public UserService(){
    }

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public Optional<User> getUserByID(String userID) {
        
        return this.userRepository.findById(userID);
    }

    public void deleteUserByID(String userID){
        this.userRepository.deleteById(userID);
    }
}
