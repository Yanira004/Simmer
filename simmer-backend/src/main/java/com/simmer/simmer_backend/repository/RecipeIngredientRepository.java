package com.simmer.simmer_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simmer.simmer_backend.model.RecipeIngredient;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

    List<RecipeIngredient> findByRecipeId(Long recipeId);

}
