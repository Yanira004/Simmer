package com.simmer.simmer_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simmer.simmer_backend.model.UserPantry;

public interface UserPantryRepository extends JpaRepository<UserPantry, Long> {
    List<UserPantry> findByUserId(Long userId);

    Optional<UserPantry> findByUserIdAndIngredientId(Long userId, Long ingredientId);
}
