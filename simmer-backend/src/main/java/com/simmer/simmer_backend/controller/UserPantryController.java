package com.simmer.simmer_backend.controller;

import com.simmer.simmer_backend.dto.PantryItemRequest;
import com.simmer.simmer_backend.dto.PantryItemResponse;
import com.simmer.simmer_backend.service.UserPantryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pantry")
@CrossOrigin(origins = "*")
public class UserPantryController {

    private final UserPantryService userPantryService;

    public UserPantryController(UserPantryService userPantryService) {
        this.userPantryService = userPantryService;
    }

    // GET: /api/pantry/user/1
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PantryItemResponse>> getPantryForUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userPantryService.getPantryForUser(userId));
    }

    // POST: /api/pantry
    @PostMapping
    public ResponseEntity<?> addToPantry(@RequestBody PantryItemRequest request) {
        try {
            PantryItemResponse created = userPantryService.addToPantry(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // PUT: /api/pantry/1
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePantryItem(@PathVariable Long id, @RequestBody PantryItemRequest request) {
        try {
            return userPantryService.updatePantryItem(id, request)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // DELETE: /api/pantry/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePantryItem(@PathVariable Long id) {
        if (!userPantryService.deletePantryItem(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}