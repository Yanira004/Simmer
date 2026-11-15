package com.simmer.simmer_backend.controller;

import com.simmer.simmer_backend.model.Allergen;
import com.simmer.simmer_backend.repository.AllergenRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allergens")
@CrossOrigin(origins = "*")
public class AllergenController {

    private final AllergenRepository allergenRepository;

    public AllergenController(AllergenRepository allergenRepository) {
        this.allergenRepository = allergenRepository;
    }

    // GET: /api/allergens
    @GetMapping
    public ResponseEntity<List<Allergen>> getAllAllergens() {
        return ResponseEntity.ok(allergenRepository.findAll());
    }

}