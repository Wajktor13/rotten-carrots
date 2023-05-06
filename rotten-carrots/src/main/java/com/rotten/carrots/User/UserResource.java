package com.rotten.carrots.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserResource {

    private UserRepository userRepository;
    private UserService userService;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userService = new UserService(userRepository);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{userID}")
    public Optional<User> getUserByID(@PathVariable("userID") String userID) {
        return Optional.ofNullable(userService.getUserByID(userID));
    }
}
