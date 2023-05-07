package com.rotten.carrots.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserResource {

    private UserService userService;

    public UserResource(UserRepository userRepository) {
        this.userService = new UserService(userRepository);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{userID}")
    public Optional<User> getUserByID(@PathVariable("userID") String userID) {
        return this.userService.getUserByID(userID);
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<?> deleteUser(@PathVariable("userID") String userID) {
        try {
            this.userService.deleteUserByID(userID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
