package com.simmer.simmer_backend.repository;

import com.simmer.simmer_backend.model.RecipeStep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeStepRepository extends JpaRepository<RecipeStep, Long> {
    List<RecipeStep> findByRecipeIdOrderByStepNumberAsc(Long recipeId);
}
