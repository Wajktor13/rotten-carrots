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

    public void updateUser(User user){
        this.userRepository.save(user);

    public Optional<User> getUserActiveAuctions(String userID){
        return  this.userRepository.findUserActiveAuctions(userID);
    }

    public Optional<User> getUserFinishedAuctions(String userID){
        return  this.userRepository.findUserFinishedAuctions(userID);
    }

    public Optional<User> getUserByNickname(String nickname){
        return this.userRepository.findUserByNickname(nickname);
    }

    public User saveUser(User newUser){
        return this.userRepository.save(newUser);
    }

    public void deleteUserByID(String userID){
        this.userRepository.deleteById(userID);
    }
}
