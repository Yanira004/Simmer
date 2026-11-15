package com.simmer.simmer_backend.controller;

import com.simmer.simmer_backend.model.User;
import com.simmer.simmer_backend.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // POST: /api/users/register
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser) {
        // TO DO : criptare parola
        User savedUser = userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

}