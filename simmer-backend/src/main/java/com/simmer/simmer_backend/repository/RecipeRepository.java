package com.simmer.simmer_backend.repository;

import com.simmer.simmer_backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByTitleContainingIgnoreCase(String title);

    List<Recipe> findByAuthorId(Long authorId);
}