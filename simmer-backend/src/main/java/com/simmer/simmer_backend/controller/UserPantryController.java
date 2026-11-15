package com.simmer.simmer_backend.controller;

import com.simmer.simmer_backend.model.UserPantry;
import com.simmer.simmer_backend.repository.UserPantryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pantry")
@CrossOrigin(origins = "*")
public class UserPantryController {

    private final UserPantryRepository userPantryRepository;

    public UserPantryController(UserPantryRepository userPantryRepository) {
        this.userPantryRepository = userPantryRepository;
    }

    // GET: /api/pantry/user/1
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPantry>> getPantryForUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userPantryRepository.findByUserId(userId));
    }

    // POST: /api/pantry
    @PostMapping
    public ResponseEntity<UserPantry> addToPantry(@RequestBody UserPantry pantryItem) {
        return ResponseEntity.ok(userPantryRepository.save(pantryItem));
    }

}