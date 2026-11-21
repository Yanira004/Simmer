package com.simmer.simmer_backend.service;

import com.simmer.simmer_backend.model.Ingredient;
import com.simmer.simmer_backend.model.Unit;
import com.simmer.simmer_backend.model.User;
import com.simmer.simmer_backend.model.UserPantry;

import com.simmer.simmer_backend.dto.PantryItemRequest;
import com.simmer.simmer_backend.dto.PantryItemResponse;
import com.simmer.simmer_backend.repository.IngredientRepository;
import com.simmer.simmer_backend.repository.UnitRepository;
import com.simmer.simmer_backend.repository.UserPantryRepository;
import com.simmer.simmer_backend.repository.UserRepository;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pantry")
@CrossOrigin(origins = "*")
public class UserPantryService {

    private final UserPantryRepository userPantryRepository;
    private final UserRepository userRepository;
    private final IngredientRepository ingredientRepository;
    private final UnitRepository unitRepository;

    public UserPantryService(
            UserPantryRepository userPantryRepository,
            UserRepository userRepository,
            IngredientRepository ingredientRepository,
            UnitRepository unitRepository) {
        this.userPantryRepository = userPantryRepository;
        this.userRepository = userRepository;
        this.ingredientRepository = ingredientRepository;
        this.unitRepository = unitRepository;
    }

    private PantryItemResponse toResponse(UserPantry item) {
        return new PantryItemResponse(
                item.getId(),
                item.getIngredient().getId(),
                item.getIngredient().getName(),
                item.getIngredient().getCalories(),
                item.getQuantity(),
                item.getUnit().getId(),
                item.getUnit().getName(),
                item.getExpirationDate());
    }

    public List<PantryItemResponse> getPantryForUser(Long userId) {
        return userPantryRepository.findByUserId(userId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public PantryItemResponse addToPantry(PantryItemRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid userId: " + request.getUserId()));
        ;
        Ingredient ingredient = ingredientRepository.findById(request.getIngredientId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ingredientId: " + request.getIngredientId()));
        ;
        Unit unit = unitRepository.findById(request.getUnitId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid unitId: " + request.getUnitId()));
        ;

        UserPantry pantryItem = new UserPantry();
        pantryItem.setUser(user);
        pantryItem.setIngredient(ingredient);
        pantryItem.setUnit(unit);
        pantryItem.setQuantity(request.getQuantity());
        pantryItem.setExpirationDate(request.getExpirationDate());

        UserPantry saved = userPantryRepository.save(pantryItem);
        return toResponse(saved);

    }

    public Optional<PantryItemResponse> updatePantryItem(Long id, PantryItemRequest request) {
        Optional<UserPantry> existingOpt = userPantryRepository.findById(id);
        if (existingOpt.isEmpty()) {
            return Optional.empty();
        }

        UserPantry item = existingOpt.get();

        if (request.getQuantity() != null) {
            item.setQuantity(request.getQuantity());
        }

        if (request.getUnitId() != null) {
            Unit unit = unitRepository.findById(request.getUnitId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid unitId: " + request.getUnitId()));
            item.setUnit(unit);
        }

        if (request.getExpirationDate() != null) {
            item.setExpirationDate(request.getExpirationDate());
        }

        UserPantry updated = userPantryRepository.save(item);
        return Optional.of(toResponse(updated));
    }

    public boolean deletePantryItem(Long id) {
        if (!userPantryRepository.existsById(id)) {
            return false;
        }

        userPantryRepository.deleteById(id);
        return true;
    }

}