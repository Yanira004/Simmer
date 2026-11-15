package com.simmer.simmer_backend.repository;

import java.util.List;

import com.simmer.simmer_backend.model.RecipeIngredient;

public interface RecipeIngredientRepository {

    List<RecipeIngredient> findByRecipeId(Long recipeId);

}
