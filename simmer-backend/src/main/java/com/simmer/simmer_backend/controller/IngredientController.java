package com.simmer.simmer_backend.controller;

import com.simmer.simmer_backend.model.Ingredient;
import com.simmer.simmer_backend.repository.IngredientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
@CrossOrigin(origins = "*")
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    // GET: /api/ingredients
    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok(ingredientRepository.findAll());
    }

    // GET: /api/ingredients/search?name=miere
    @GetMapping("/search")
    public ResponseEntity<List<Ingredient>> searchIngredients(@RequestParam String name) {
        return ResponseEntity.ok(ingredientRepository.findByNameContainingIgnoreCase(name));
    }
}